package algorithm10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zyh
 * @create 2019-09-25 16:41
 */
public class Greedy {
    public static void main(String[] args) {
        //创建存放电台覆盖信息的表
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //创建每个电台的信息加入到表
        HashSet<String> address1 = new HashSet<>();
        address1.add("北京");
        address1.add("上海");
        address1.add("天津");

        HashSet<String> address2 = new HashSet<>();
        address2.add("广州");
        address2.add("北京");
        address2.add("深圳");

        HashSet<String> address3 = new HashSet<>();
        address3.add("成都");
        address3.add("上海");
        address3.add("杭州");

        HashSet<String> address4 = new HashSet<>();
        address4.add("上海");
        address4.add("天津");

        HashSet<String> address5 = new HashSet<>();
        address5.add("杭州");
        address5.add("大连");

        broadcasts.put("K1",address1);
        broadcasts.put("K2",address2);
        broadcasts.put("K3",address3);
        broadcasts.put("K4",address4);
        broadcasts.put("K5",address5);

        HashSet<String> alladdress = new HashSet<>();
        alladdress.add("北京");
        alladdress.add("天津");
        alladdress.add("上海");
        alladdress.add("杭州");
        alladdress.add("成都");
        alladdress.add("大连");
        alladdress.add("深圳");
        alladdress.add("广州");

        //选中的电台集合
        ArrayList<String> select = new ArrayList<>();

        //临时覆盖地区
        HashSet<String> temp = new HashSet<>();

        String maxKey = null;

        //如果还有剩余的地区就一直循环
        while (alladdress.size() != 0){
            //每次遍历要初始化maxKey
            maxKey = null;
            //遍历表
            for (String key : broadcasts.keySet()){
                //初始化临时地区
                temp.clear();
                //将遍历到的电台的地区取出
                HashSet<String> address = broadcasts.get(key);
                //将取出的地区加入到临时地区集合中
                temp.addAll(address);
                //临时地区集合与现有的所有地区取交集并放回到临时地区集合
                temp.retainAll(alladdress);
                //如果这个电塔覆盖的地区与剩余的地区有交集，且这个电塔覆盖的地区与剩余地区相交的数量大于上一次，就更新maxkey
                if (temp.size() > 0 && (maxKey == null || temp.size() > broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }
            //如果找到了本次覆盖地区最多的电塔，就把它选中，并将它覆盖的地区从剩余地区中移除
            if (maxKey != null){
                select.add(maxKey);
                alladdress.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("结果为：" + select);
    }
}
