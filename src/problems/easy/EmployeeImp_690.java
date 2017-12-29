package problems.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImp_690 {
    public int getImportance(List<Employee> employees, int id) {
        final int[] sum = {0};
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        while (!q.isEmpty()) {
            int i = q.poll();
            Employee e = find(employees, i);
            if (e != null) {
                sum[0] += e.importance;
                List<Integer> sub = e.subordinates;
                if (!sub.isEmpty()) {
                    sub.forEach(s -> {
                        Employee emp = find(employees, s);
                        if (emp != null) {
                            q.offer(emp.id);
                        }
                    });
                }
            }
        }
        return sum[0];
    }

    private Employee find(List<Employee> employees, int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }

    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
