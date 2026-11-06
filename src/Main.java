class run_code{
    static void main() {
        run_code run = new run_code();
        Tree_element root = make(55);
        root.left = make(12);
        root.middle = make(15);
        root.middle.right = make(34);
        root.middle.middle = make(5);
        root.middle.middle.left = make(24);
        root.right = make(69);
        root.right.left = make(77);
        root.right.right = make(75);
        root.right.left.left = make(65);
        root.right.left.middle = make(52);
        root.right.left.right = make(80);
        run.allPaths.clear();
        run.obhod(root, null);
        run.find_max();

    }
    private PathList allPaths = new PathList();
    private IntList currentPath = new IntList();

    private static Tree_element make(int value) {
        Tree_element n = new Tree_element();
        n.data = value;
        return n;
    }

    private void obhod(Tree_element tree, Integer parentValue) {
        if (tree == null){
            return;
        }

        if (parentValue == null || tree.data %2 == 1) {
            currentPath.clear();
            go_down(tree);
        }
        obhod(tree.left,  tree.data);
        obhod(tree.middle,  tree.data);
        obhod(tree.right, tree.data);
    }

    private void go_down(Tree_element tree) {
        currentPath.add(tree.data);
        boolean goLeft  = tree.left  != null && tree.left.data % 2 == 1;
        boolean goRight = tree.right != null && tree.right.data % 2 == 1;
        boolean goMidle = tree.middle != null && tree.middle.data % 2 == 1;

        if (!goLeft && !goRight && !goMidle) {
            allPaths.add(new IntList(currentPath));
        } else {
            if (goLeft){
                go_down(tree.left);
            }
            if (goRight){
                go_down(tree.right);
            }
            if (goMidle){
                go_down(tree.middle);
            }
        }
        currentPath.removeLast();
    }

    private void find_max(){
        if (allPaths.size() == 0) {
            System.out.println("Путей нет");
            return;
        }
        int maxSize = 0;
        for (int i = 0; i < allPaths.size(); i++) {
            int s = allPaths.get(i).size();
            if (s > maxSize){
                maxSize = s;
            }
        }
        System.out.println("Максимальная длина: " + maxSize);
        for (int i = 0; i < allPaths.size(); i++) {
            IntList p = allPaths.get(i);
            if (p.size() == maxSize) {
                System.out.print("[");
                p.print_String();
                System.out.print("]");
            }
        }
    }
}






