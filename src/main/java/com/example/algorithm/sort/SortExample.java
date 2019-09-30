package com.example.algorithm.sort;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.stereotype.Service;
import sun.plugin.javascript.navig.Array;

import java.io.InputStream;
import java.util.*;

@Service
public class SortExample {
    //N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    public static void sort2750() {
        Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
        List<Integer> tempList = new ArrayList<>();
        int cnt = scan.nextInt();
        for(int i =0;i<cnt;i++){
            tempList.add(scan.nextInt());
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<tempList.size();i++) {

            if(!list.contains(tempList.get(i))) { //포함되어 있나 없나 체크

                list.add(tempList.get(i));
            }
        }

        Collections.sort(list);

        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        scan.close();

    }
/**
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이**/
    public void sort2180(){
        Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
        List<Integer> tempList = new ArrayList<>();
        int cnt = scan.nextInt();

        Map<Integer,Object> mode = new HashMap<>();
        for(int i =0;i<cnt;i++){
            tempList.add(scan.nextInt());

            if(mode.get(scan.nextInt())!= null) {
                mode.put(scan.nextInt(), scan.nextInt()+1);
            }else{
                mode.put(scan.nextInt(), 1);
            }
        }




    }
}
