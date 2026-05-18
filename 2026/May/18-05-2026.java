


class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Set<Integer> head = new HashSet<>();
        Set<Integer> tail = new HashSet<>();
        boolean[] visited = new boolean[n];

        head.add(0);
        tail.add(n - 1);
        visited[0] = true;
        visited[n - 1] = true;

        int steps = 0;

        while (!head.isEmpty() && !tail.isEmpty()) {

            if (head.size() > tail.size()) {
                Set<Integer> temp = head;
                head = tail;
                tail = temp;
            }

            Set<Integer> nextFrontier = new HashSet<>();

            for (int curr : head) {
                
                List<Integer> neighbors = new ArrayList<>();

                neighbors.add(curr + 1);
                neighbors.add(curr - 1);
                
                if (graph.containsKey(arr[curr])) {
                    neighbors.addAll(graph.get(arr[curr]));
                    graph.remove(arr[curr]); 
                }

                for (int next : neighbors) {
                    if (next >= 0 && next < n) {

                        if (tail.contains(next)) {
                            return steps + 1;
                        }
                        if (!visited[next]) {
                            visited[next] = true;
                            nextFrontier.add(next);
                        }
                    }
                }
            }
            head = nextFrontier;
            steps++;
        }

        return -1;
    }
}