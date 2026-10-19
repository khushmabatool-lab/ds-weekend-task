import java.util.Scanner;

public class CircularQueue {
    static int[] queue = new int[5];
    static int front = -1;
    static int rear = -1;
    static int size = 0;
    static final int CAPACITY = 5;

    static void enqueue(int value) {
        if (size == CAPACITY) {
            System.out.println("Queue is Full!");
            return;
        }

        if (size == 0) {
            front = 0;
        }

        rear = (rear + 1) % CAPACITY;
        queue[rear] = value;
        size++;

        System.out.println(value + " inserted successfully.");
    }

    static void dequeue() {
        if (size == 0) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println("Removed element: " + queue[front]);
        front = (front + 1) % CAPACITY;
        size--;

        if (size == 0) {
            front = -1;
            rear = -1;
        }
    }

    static void peek() {
        if (size == 0) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    static void display() {
        if (size == 0) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % CAPACITY] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Enqueue (Insert)");
            System.out.println("2. Dequeue (Remove)");
            System.out.println("3. Peek (Front Element)");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = input.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        input.close();
    }
}