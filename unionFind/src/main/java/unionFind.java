
public class unionFind {

    // The number of elements in this find
    private int size;

    //Used to track the size of the component
    private int [] sz;

    //id[i] points to the parent of i, if if[i] = i then i is a root node
    private int[] id;

    //Tracks the numbers of components in the union  find
    private int numComponents;

    public unionFind(int size){

        if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");

        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i; // Link to itself (self root)
            sz[i] = 1; // Each component is originally of size one
        }
    }

    //Find which component/set'p' belongs to, takes amortised constant time
    public int find(int p ){

        // find the root of the component
        int root = p;
        while (root != id[root]) root = id[root];

        //Compress the path leading back to the root
        // Doing this operation is caclled "path compression"
        //and is what gives us amortised time complexity

        while (p != root){
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }
    //Return whether or not the elements 'p' belongs to
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    //Returns the size of the components/set'p' belongs to
    public int componentSize(int p){
        return sz[find(p)];
    }

    // Return the number of elements in this UnionFind/Disjoint set
    public int size() {
        return size;
    }

    //Returns the numbers of remaining components/sets
    public int components(){
        return numComponents;
    }

    //Unify the componets/sets containing elements 'p' ans 'q'
    public void unify(int p, int q){
        int root1 = find(p);
        int root2 = find(q);

        //These elements are already in the same group
        if(root1 == root2) return;

        //Merge smaller components/set into the larges one
        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
        }

        //Decreased the numbers of roots by one.
        numComponents--;
    }

}
