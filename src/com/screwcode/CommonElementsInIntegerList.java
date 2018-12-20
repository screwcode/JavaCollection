package com.screwcode;

import java.util.*;
import java.util.stream.Collectors;

public class CommonElementsInIntegerList {
    public static Set<Integer> commonElementsIn(List<Integer> a, List<Integer> b) {
        // 在这里写你自己的实现
        Set<Integer> result = a.stream().filter(t -> b.contains(t)).collect(Collectors.toSet());
        return result;
    }
}
