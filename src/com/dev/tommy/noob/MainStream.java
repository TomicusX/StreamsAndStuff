package com.dev.tommy.noob;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStream {

    public static void main(String[] args){

        System.out.println("Testing streams");

        streamTestingWithAFlatMap();

        basicStreamTesting();

        testingStreamIterate();

        lamdaWithFunctionInterfaceTest();
    }

    public static void basicStreamTesting() {

        System.out.println("basic streamTesting...");
        String[] stringArray = {"John", "Sally", "George"};

        Stream.of(stringArray).forEach(name -> printUpperCase(name));

        System.out.println("peeking twice through stream...");
        System.out.println("Joiningg\n"+Stream.of(stringArray).collect(Collectors.joining(":::: ")));


        System.out.println("printing elements that are less than 5 characters...");
        Stream.of(stringArray).filter(name -> (name.length() < 5)).forEach(name -> printUpperCase(name));

        List<String> nameList =  Stream.of(stringArray).collect(Collectors.toList());
        System.out.println("printing elements in new list...");
        for (String name: nameList) {
            printUpperCase(name);
        }

        System.out.println("basic streamTesting Done!");
    }

    public static void streamTestingWithAFlatMap() {
        System.out.println("streamTesting with flat map...");

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        Stream.of(namesNested).forEach(name-> System.out.println(name));

        System.out.println("Size namesNested" + namesNested.size());

        System.out.println("Flat Map");

        List newList = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println("Size flatMap" + newList.size());

        System.out.println("streamTesting with flat map Done!");
    }

    public static void lamdaWithFunctionInterfaceTest() {
        System.out.println("lamdaWithFunctionInterfaceTest testing...");

        String coolString = "Aid";

        MyFirstFuncInterface interfaceImpl = s -> "Cool " + s;

        System.out.println(interfaceImpl.getCoolString(coolString));

        System.out.println("lamdaWithFunctionInterfaceTest testing Done!");
    }


    public static void printUpperCase (String name) {
        System.out.println(name.toUpperCase());
    }

    public static void testingStreamIterate() {
        Stream<Integer> infiniteStream = Stream.iterate(3, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

        collect.stream().peek(number -> System.out.println(number)).collect(Collectors.toList());
    }
}
