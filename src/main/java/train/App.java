package train;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pc on 2017/8/4.
 */
public class App {

    public static void main(String[] args)
    {
        //测试数据
        String[] towns = new String[]{
                "A,B,5",
                "B,C,4",
                "C,D,8",
                "D,C,8",
                "D,E,6",
                "A,D,5",
                "C,E,2",
                "E,B,3",
                "A,E,7",
        };

        //创建线路
        List<Route> routes = new LinkedList<>();
        Arrays.stream(towns)
                .forEach((String s) -> {
                    routes.add(new Route(s.split(",")[0],s.split(",")[1],Double.valueOf(s.split(",")[2])));
                });

        //初始化线路图
        Graph graph = new Graph(routes);

        //1 A-B-C
        System.out.println(graph.getDistance("A","B","C"));

        //2 A-D
        System.out.println(graph.getDistance("A","D"));

        //3 A-D-C
        System.out.println(graph.getDistance("A","D","C"));

        //4 A-E-B-C-D
        System.out.println(graph.getDistance("A","E","B","C","D"));

        //5 A-E-D
        System.out.println(graph.getDistance("A","E","D"));

        //6
        System.out.println(graph.getRoutes("C","C").getRoutesByStop(3,"<=").size());

        //7
        System.out.println(graph.getRoutes("A","C").getRoutesByStop(4).size());

        //8
        System.out.println(graph.getRoutes("A","C").getMinLength());

        //9
        System.out.println(graph.getRoutes("B","B").getMinLength());

        //10
        System.out.println(graph.getRoutes("C","C").getNumByLength(30d,"<"));
    }


}
