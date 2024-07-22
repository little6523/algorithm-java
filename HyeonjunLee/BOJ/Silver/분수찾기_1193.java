package Bakjoon;// 풀이 2 -> 등차 수열의 합 공식 이용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분수찾기_1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int s = 0, l = 0;
        while (s < n) {
            s = l * (1 + l) / 2;
            l++;
        }

        l--;
        s -= l;

        int numerator = 0, denominator = 0;

        if (l % 2 == 0) {

            numerator = 1;
            denominator = l;

            for (int i = 1; i < n - s; i++) {
                numerator += 1;
                denominator -= 1;
            }
        }

        else if (l % 2 == 1) {

            numerator = l;
            denominator = 1;

            for (int i = 1; i < n - s; i++) {
                numerator -= 1;
                denominator += 1;
            }
        }

        System.out.println(numerator + "/" + denominator);

    }
}

// 풀이 1 -> 그대로 구현

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        int numerator = 1, denominator = 1;
//        int dir = 0;
//        // dir => 0: 아래로 한 칸 또는 오른쪽을 한 칸 / 1: 왼쪽 아래로 내려가는 방향 / 2: 오른쪽 위로 올라가는 방향
//
//        for (int i = 1; i < n; i++) {
//
//            if (dir == 0) {
//                if (numerator == 1) {
//                    denominator += 1;
//                    dir = 1;
//                }
//
//                else if (denominator == 1) {
//                    numerator += 1;
//                    dir = 2;
//                }
//            }
//
//            else if (dir == 1) {
//                numerator += 1;
//                denominator -= 1;
//
//                if (denominator == 1) {
//                    dir = 0;
//                }
//            }
//
//            else if (dir == 2) {
//                numerator -= 1;
//                denominator += 1;
//
//                if (numerator == 1) {
//                    dir = 0;
//                }
//            }
//        }
//
//        System.out.println(numerator + "/" + denominator);
//
//    }
//}