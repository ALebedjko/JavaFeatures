package main.java.org.banjalive.JavaFeatures;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;


/**
 * Created by a.lebedjko on 15.04.2017.
 */
public class FindCartesianProduct {
    public static void main(String[] args) {
        Set<Character> first = ImmutableSet.of('1', '2', '3', '4', '5', '6');
        Set<Character> second = ImmutableSet.of('2', '3', '4', '5', '6', '7', '8');
        Set<List<Character>> result =
                Sets.cartesianProduct(ImmutableList.of(first, second));

        System.out.println("result count -> " + result.size());
        for (List characterList: result
             ) {
            System.out.println(characterList);
        }
    }
}
