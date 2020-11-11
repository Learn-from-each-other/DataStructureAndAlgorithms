package tree.huffmancode;

import java.io.*;
import java.util.*;

/**
 * @author zyh
 * @create 2019-09-22 10:08
 */
public class HuffmanCodeDemo{
    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
//        byte[] contentBytes = content.getBytes();
//        System.out.println(Arrays.toString(contentBytes));
//        HuffmanCode huffmanCode = new HuffmanCode(contentBytes);
////        huffmanCode.preOrder();
//        System.out.println("*******************************");
//        Map<Byte, String> code = huffmanCode.getHuffmanCodesTable();
//        for (Map.Entry<Byte,String> entry : code.entrySet()){
//            System.out.print(" ["+ entry.getKey()+":"+entry.getValue()+"] ");
//        }
//        System.out.println("*******************************");
//        byte[] zip = huffmanCode.zip();
//        System.out.println(Arrays.toString(zip));
//        System.out.println("*******************************");
//
//        System.out.println(huffmanCode.unZip(zip));

        HuffmanZip.zipFile("d://Data/SCRTMenuToolbarV3.ini","d://Data/ddddd.zip");

        HuffmanZip.unZipFile("d://Data/ddddd.zip","d://Data/ddddddddddddd.unzip");
    }
}


class HuffmanCode {
    private byte[] bytes;
    private HuffmanNode root;
    List<HuffmanNode> nodes;
    Map<Byte, String> huffmanCodesTable;

    public Map<Byte, String> getHuffmanCodesTable() {
        return huffmanCodesTable;
    }

    public List<HuffmanNode> getNodes() {
        return nodes;
    }

    public HuffmanCode(byte[] bytes) {
        this.bytes = bytes;

        nodes = getNodes(bytes);

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            HuffmanNode leftNode = nodes.get(0);
            HuffmanNode rightNode = nodes.get(1);

            HuffmanNode parent = new HuffmanNode(null, leftNode.weight + rightNode.weight);

            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }

        this.root = nodes.get(0);

        huffmanCodesTable = new HashMap<>();
        getCode();
    }


    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空");
        }
    }

    private static List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> nodes = new ArrayList<>();

        Map<Byte, Integer> counts = new HashMap<>();

        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }


    private void getCode(HuffmanNode node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);

        stringBuilder1.append(code);

        if (node != null) {
            if (node.data == null) {
                getCode(node.left, "0", stringBuilder1);
                getCode(node.right, "1", stringBuilder1);
            } else {
                huffmanCodesTable.put(node.data, stringBuilder1.toString());
            }
        }
    }

    StringBuilder stringBuilder = new StringBuilder();

    public void getCode() {
        if (root == null) {
            return;
        }
        getCode(root.left, "0", stringBuilder);
        getCode(root.right, "1", stringBuilder);
    }

    public byte[] zip() {
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(huffmanCodesTable.get(b));
        }

        int len = (stringBuilder.length() + 7) / 8;

        byte[] huffmanCodeBytes = new byte[len];

        int index = 0;

        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;

            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }


    private String byte2String(boolean flag, byte b) {
        int temp = b;

        if (flag) {
            temp |= 256;
        }

        String str = Integer.toBinaryString(temp);

        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    public String unZip(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean flag = (i == bytes.length - 1);
            stringBuilder.append(byte2String(!flag, b));
        }
//        System.out.println(stringBuilder.toString());
        HashMap<String, Byte> map = new HashMap<>();

        for (Map.Entry<Byte, String> entry : huffmanCodesTable.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        ArrayList<Byte> list = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);

                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }

            list.add(b);
            i += count;
        }

        byte[] b = new byte[list.size()];

        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }

        return new String(b);
    }

}

class HuffmanZip{

    public static void zipFile(String src ,String dest){

        OutputStream os = null;
        ObjectOutputStream oos = null;
        FileInputStream is = null;

        try {
            is = new FileInputStream(src);
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            HuffmanCode huffmanCode = new HuffmanCode(bytes);
            byte[] zip = huffmanCode.zip();

            os = new FileOutputStream(dest);
            oos = new ObjectOutputStream(os);

            oos.writeObject(zip);
            oos.writeObject(huffmanCode.getHuffmanCodesTable());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void unZipFile(String src ,String dest){
        InputStream is = null;
        ObjectInputStream ois= null;

        OutputStream  os = null;

        try {
            is = new FileInputStream(src);
            ois = new ObjectInputStream(is);

            byte[] zip = (byte[]) ois.readObject();

            Map<Byte, String> codesTable = (Map<Byte, String>) ois.readObject();

//            HuffmanCode huffmanCode = new HuffmanCode(zip);
//
//            String res = huffmanCode.unZip(zip);

            os = new FileOutputStream(dest);

//            os.write(res.getBytes());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                ois.close();
                is.close();
                os.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
