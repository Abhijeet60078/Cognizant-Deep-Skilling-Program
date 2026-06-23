class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    Task head = null;

    public void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
            return;
        }

        Task temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newTask;
    }

    public void searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {
                System.out.println("Task Found");
                System.out.println(
                        temp.taskId + " "
                        + temp.taskName + " "
                        + temp.status
                );
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    public void displayTasks() {

        Task temp = head;

        while (temp != null) {
            System.out.println(
                    temp.taskId + " "
                    + temp.taskName + " "
                    + temp.status
            );

            temp = temp.next;
        }
    }

    public void deleteTask(int id) {

        if (head == null) {
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {

        TaskManagementSystem tasks = new TaskManagementSystem();

        tasks.addTask(1, "Design UI", "Pending");
        tasks.addTask(2, "Write Code", "In Progress");
        tasks.addTask(3, "Testing", "Pending");

        System.out.println("All Tasks:");
        tasks.displayTasks();

        System.out.println("\nSearch Task:");
        tasks.searchTask(2);

        tasks.deleteTask(1);

        System.out.println("\nAfter Delete:");
        tasks.displayTasks();
    }
}