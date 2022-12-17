class Allocator {

    int[] memory;

    public Allocator(int n) {
        memory = new int[n];
        Arrays.fill(memory, -1);
    }
    
    public int allocate(int size, int mID) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == -1) {
                int defaultIndex = i;
                int count = 0;
                while (i+count < memory.length && memory[i+count] == -1) {
                    count++;
                    if (count == size) {
                        for (int j = defaultIndex; j < (defaultIndex+size); j++) {
                            memory[j] = mID;
                        }
                        return defaultIndex;
                    }
                    if (count >= memory.length) {
                        return -1;
                    }
                }
                i += count;
            }
        }
        return -1;
    }
    
    public int free(int mID) {
        int count = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == mID) {
                memory[i] = -1;
                count++;
            }
        }
        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
