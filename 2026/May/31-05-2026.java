
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids ) {
        Arrays.sort(asteroids );

        long currentMass = mass;

        for (int num : asteroids ) {
            if (currentMass < num)
                return false;
            currentMass += num;
        }

        return true;
    }
}




