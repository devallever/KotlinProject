//package com.allever.app.kotlin.generic;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Allever
// */
//public class GenericTest {
//    public static void main(String[] args) {
//        List<Animal> animalList = new ArrayList<>();
//        animalList.add(new Animal());
//
//        List<Cat> catList = new ArrayList<>();
//        catList.add(new Cat());
//        catList.add(new GarfieldCat());
//        //报错
//        catList.add(new Animal());
//
//        List<GarfieldCat> garfieldCatList = new ArrayList<>();
//        garfieldCatList.add(new GarfieldCat());
//        garfieldCatList.get(0);//返回 GarfieldCat
//
//        List<? extends Cat> catListExtend = catList;
//        catListExtend = garfieldCatList;
//        //报错 上界是Cat
//        catListExtend = animalList;
//        //? extends 不能add
//        catListExtend.add(new Cat());
//        catListExtend.add(new Animal());
//        catListExtend.add(new GarfieldCat());
//        Animal animal = catListExtend.get(0);
//        Cat cat = catListExtend.get(0);
//        GarfieldCat garfieldCat = garfieldCatList.get(0);
//
//        List<? super Cat> catListSuper = catList;
//        catListSuper = animalList;
//        //报错 下界是Cat 即 Cat和父类
//        catListSuper = garfieldCatList;
//        catListSuper.add(new Animal());
//        catListSuper.add(new Cat());
//        catListSuper.add(new GarfieldCat());
////        Cat cat = catListSuper.get(0);
////        Animal animal = catListSuper.get(0);
////        GarfieldCat garfieldCat = catListSuper.get(0);
//        Object o = catListSuper.get(0);
//    }
//}
