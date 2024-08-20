package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        // queue: 현재 처리 중인 고객 큐, readyQueue: 아직 도착하지 않은 고객 큐
        Queue<Customer> queue = new LinkedList<>();
        PriorityQueue<Customer> readyQueue = new PriorityQueue<>(new CustomerComparator());

        // 업무 처리 조건 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 처음 큐에 있는 고객 수
        int t = Integer.parseInt(st.nextToken()); // 한 고객당 할당 작업 시간
        int w = Integer.parseInt(st.nextToken()); // 총 작업 시간

        // 고객 정보 입력
        int id, time;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            id = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            queue.add(new Customer(id, time, 0));
        }

        int m = Integer.parseInt(br.readLine());
        int arrival;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            id = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            arrival = Integer.parseInt(st.nextToken());
            readyQueue.add(new Customer(id, time, arrival));
        }

        // 시간에 따른 고객 작업 처리 로직
        int now = 0;
        int nowCustomerId, nowCustomerTime;
        Customer nowCustomer;
        while (true) {
            nowCustomer = queue.peek();
            nowCustomerId = nowCustomer.getId();
            nowCustomerTime = nowCustomer.getTime();

            if (nowCustomerTime >= t) {
                if (w - now < t) {
                    t = w - now;
                }

                for (int j = 0; j < t; j++) {
                    System.out.println(nowCustomerId);
                }

                now += t;
                nowCustomerTime -= t;
            } else {
                if (w - now < nowCustomerTime) {
                    nowCustomerTime = w - now;
                }

                for (int j = 0; j < nowCustomerTime; j++) {
                    System.out.println(nowCustomerId);
                }

                now += nowCustomerTime;
                nowCustomerTime = 0;
            }

            nowCustomer.setTime(nowCustomerTime);

            if (now >= w) {
                break;
            }

            while (!readyQueue.isEmpty() && readyQueue.peek().getArrival() <= now) {
                queue.offer(readyQueue.poll());
            }

            if (nowCustomerTime == 0) {
                queue.poll();
            } else {
                nowCustomer.setTime(nowCustomerTime);
                queue.offer(queue.poll());
            }
        }
    }
}

class Customer {

    int id;
    int time;
    int arrival;

    public Customer(int id, int time, int arrival) {
        this.id = id;
        this.time = time;
        this.arrival = arrival;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public int getArrival() {
        return arrival;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

class CustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getArrival() < o2.getArrival()) {
            return -1;
        } else {
            return 1;
        }
    }
}