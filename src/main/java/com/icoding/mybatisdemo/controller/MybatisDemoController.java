package com.icoding.mybatisdemo.controller;

import com.icoding.mybatisdemo.config.BeanInvoker;
import com.icoding.mybatisdemo.pojo.Department;
import com.icoding.mybatisdemo.pojo.WeightDto;
import com.icoding.mybatisdemo.service.DepartmentService;
import com.icoding.mybatisdemo.service.Shape;
import com.icoding.radishspringbootautoconfigure.service.RadishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.*;

@RestController
public class MybatisDemoController {

    @Autowired
    private RadishService radishService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BeanInvoker beanInvoker;

    @RequestMapping("/hello")
    public String hello(){

        beanInvoker.doDistribute();

        return radishService.getRadish();
    }

    @RequestMapping("/add")
    public String addDepartment() {

        Department department = new Department();
        departmentService.add(department);
        return "ok";
    }

    @RequestMapping("/list")
    public List<Department> getDepartmentList() {
        // 不注入Druid 数据源时,默认使用的harika 管理数据源
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getClass());

        return departmentService.getDepartmentList();
    }

    public static void main(String[] args) {

//        Integer [] a = new Integer[]{1,2,3,4};
//        List<Integer> integers = Arrays.asList(a);
//        Set<Integer> set = new HashSet<Integer>(integers);
//        List<Integer> list = new ArrayList<>(set);
//        Collections.reverse(list);
//        System.out.println(list);

        List<WeightDto> list = new ArrayList<>();
        list.add(new WeightDto("1号", 20));
        list.add(new WeightDto("2号", 30));
        list.add(new WeightDto("3号", 10));
        list.add(new WeightDto("4号", 50));
        list.add(new WeightDto("5号", 10));
        for (int i = 1; i<= 100; i++) {
            WeightDto weightedRandomAtom = getWeightedRandomAtom(list);
            System.out.println("销售权重："+weightedRandomAtom.getWeight() + "销售ID：" + weightedRandomAtom.getKey());
        }

        System.out.println("当前IP:"+getServer());

    }

    public static WeightDto getWeightedRandomAtom(List<WeightDto> atomList){
        if(atomList.isEmpty()){
            return null;
        }
        int weightSum = 0;//总权值
        for(WeightDto atom : atomList){
            weightSum += atom.getWeight();
        }
        //获取总权值之间任意一随机数
        int random = new Random().nextInt(weightSum);  //random in [0, weightSum)
        System.out.println(random);
        //{.},{..},{...},{....}...根据权值概率区间，获得加权随机对象
        for(WeightDto atom : atomList){
            random -= atom.getWeight();
            if (random < 0) {
                return atom;
            }
        }
        return null;
    }

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap =  new HashMap<String, Integer>();

        serverMap.put("192.168.1.100", 1);
        serverMap.put("192.168.1.101", 1);
        // 权重为4
        serverMap.put("192.168.1.102", 4);
        serverMap.put("192.168.1.103", 1);
        serverMap.put("192.168.1.104", 1);
        // 权重为3
        serverMap.put("192.168.1.105", 3);
        serverMap.put("192.168.1.106", 1);
        // 权重为2
        serverMap.put("192.168.1.107", 2);
        serverMap.put("192.168.1.108", 1);
        serverMap.put("192.168.1.109", 1);
        serverMap.put("192.168.1.110", 1);

        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();

        List<String> serverList = new ArrayList<String>();
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }

        java.util.Random random = new java.util.Random();
        int randomPos = random.nextInt(serverList.size());

        return serverList.get(randomPos);
    }
}
