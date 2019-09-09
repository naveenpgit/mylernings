package java8;

import java.util.*;
import java.util.stream.Collectors;

public class LearnCollectors {

    public static void main(String[] args) {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80));
        list.add(new Hosting(2, "linode.com", 90));
        list.add(new Hosting(3, "digitalocean.com", 120));
        list.add(new Hosting(4, "aws.amazon.com", 200));
        list.add(new Hosting(5, "mkyong.com", 1));

        // data = id, value - websites
        System.out.println(list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getWebsites)));

        // data = name, value - websites
        System.out.println(list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites)));

        // Same with result1, just different syntax
        // data = id, value = name
        System.out.println(list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName())));

        list.add(new Hosting(6, "linode.com", 100)); // new line

        // data = name, value - websites , but the data 'linode' is duplicated!?
        System.out.println(list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldv, newv) -> oldv)));

        //Map to new value incase of duplication
        System.out.println(list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldv, newv) -> newv)));

        //List to Map – Sort & Collect
        Map sortedMap = list.stream().sorted(Comparator.comparingLong(Hosting::getWebsites).reversed()).collect(Collectors.toMap(x -> x.getName(), x -> x.getWebsites(), (o, n) -> n, LinkedHashMap::new));
        System.out.println(sortedMap);

        list.stream().forEach(x -> System.out.println(x.toString()));
        System.out.println("============================================================");
        list.stream().forEachOrdered(System.out::println);
    }

    private static class Hosting {
        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getWebsites() {
            return websites;
        }

        public void setWebsites(long websites) {
            this.websites = websites;
        }

        private int Id;
        private String name;
        private long websites;

        public Hosting(int id, String name, long websites) {
            Id = id;
            this.name = name;
            this.websites = websites;
        }


        @Override
        public String toString() {
            return "Hosting{" +
                    "Id=" + Id +
                    ", name='" + name + '\'' +
                    ", websites=" + websites +
                    '}';
        }
    }
}
