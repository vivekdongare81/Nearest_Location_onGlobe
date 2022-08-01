package com.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TwoD_BinaryTree {

    public static class TwoD_Node {
        TwoD_Node left = null;
        TwoD_Node right = null;
        String address;
        final int numDims;

        // This is the data. Each node has K different properties
        public final TwoD_Point point;

        public TwoD_Node(List<Double> props) {
            this.point = new TwoD_Point(props);
            this.numDims = props.size();

        }

        public TwoD_Node(TwoD_Point point, String address) {
            this.point = point;
            this.numDims = point.props.size();
            this.address = address;
        }

        private void add(TwoD_Node n) {
            this.add(n, 0);
        }

        // add recursively by comparing x and y alternatively
        private void add(TwoD_Node n, int k) {

            if (n.point.get(k) < point.get(k)) {
                if (left == null) {
                    left = n;
                } else {
                    left.add(n, k + 1);
                }
            } else {
                if (right == null) {
                    right = n;
                } else {
                    right.add(n, k + 1);
                }
            }

        }

        @Override
        public String toString() {
            return "Nearest Location is --> " + this.point.toString() + " -- " + this.address;
        }
    }

    // 2D point to be stored in Node
    public static class TwoD_Point {
        final List<Double> props;

        public TwoD_Point(List<Double> props) {
            this.props = props;
        }

        Double get(int depth) {
            return props.get(depth % props.size());
        }

        Integer size() {
            return props.size();
        }

        @Override
        public String toString() {
            return props.toString();
        }
    }

    TwoD_Node root = null;
    final int numDims;

    public TwoD_BinaryTree(int numDims) {
        this.numDims = numDims;
    }

    public TwoD_BinaryTree(TwoD_Node root) {
        this.root = root;
        this.numDims = root.point.size();
    }

    public TwoD_BinaryTree(List<List<Double>> points) {
        numDims = points.get(0).size();
        root = new TwoD_Node(points.get(0));

        for (int i = 1, numPoints = points.size(); i < numPoints; i++) {
            List<Double> point = points.get(i);
            TwoD_Node n = new TwoD_Node(point);
            root.add(n);
        }
    }

    public void add(TwoD_Node point) {
        if (root == null) {
            root = point;
        } else {
            root.add(point);
        }
    }

    public void add(List<Double> point) {
        TwoD_Node n = new TwoD_Node(point);
        if (root == null) {
            root = n;
        } else {
            root.add(n);
        }
    }

    public TwoD_Node findNearest(TwoD_Point target) {
        return findNearest(root, target, 0);
    }

    private TwoD_Node findNearest(TwoD_Node root, TwoD_Point target, int depth) {

        if (root == null)
            return null;

        TwoD_Node nextBranch = null;
        TwoD_Node otherBranch = null;

        // compare the property appropriate for the current depth
        if (target.get(depth) < root.point.get(depth)) {
            nextBranch = root.left;
            otherBranch = root.right;
        } else {
            nextBranch = root.right;
            otherBranch = root.left;
        }

        // recurse down the branch that's best according to the current depth
        TwoD_Node temp = findNearest(nextBranch, target, depth + 1);
        TwoD_Node best = closest(temp, root, target);

        long radiusSquared = distSquared(target, best.point);

        long dist = (long) (target.get(depth) - root.point.get(depth));

        if (radiusSquared >= (dist * dist)) {
            temp = findNearest(otherBranch, target, depth + 1);
            best = closest(temp, best, target);
        }

        return best;
    }

    TwoD_Node closest(TwoD_Node n0, TwoD_Node n1, TwoD_Point target) {
        if (n0 == null)
            return n1;

        if (n1 == null)
            return n0;

        long d1 = distSquared(n0.point, target);
        long d2 = distSquared(n1.point, target);

        if (d1 < d2)
            return n0;
        else
            return n1;
    }

    static long distSquared(TwoD_Point p0, TwoD_Point p1) {

        double radius = 6371.0;

        double latP1 = Math.toRadians(p0.get(0));
        double lngP1 = Math.toRadians(p0.get(1));
        double latP2 = Math.toRadians(p1.get(0));
        double lngP2 = Math.toRadians(p1.get(1));

        double distance = Math.pow(Math.sin((latP2 - latP1) / 2.0), 2)
                + Math.cos(latP1) * Math.cos(latP2) * Math.pow(Math.sin((lngP2 - lngP1) / 2.0), 2);
        distance = 2.0 * radius * Math.asin(Math.sqrt(distance));

        return (long) distance;

    }

    public static void main(String[] args) throws IOException {

        // TODO Auto-generated method stub
        File file = new File("C:\\Users\\donga\\eclipse-workspace\\Nearest_Location\\dataSet.csv");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Latitude :");
        double lat = (double) Float.parseFloat("1.3272"); // TODO- sc.nextLine()
        System.out.println(lat);

        System.out.println("Enter Longitude :");
        double longi = (double) Float.parseFloat("103.7111"); // TODO- sc.nextLine()
        System.out.println(longi);

        String st = "";

        TwoD_BinaryTree tree = new TwoD_BinaryTree(2);

        while ((st = reader.readLine()) != null) {

            String[] stArr = st.split(",");

            double lati = (double) Float.parseFloat(stArr[0]);
            double longii = (double) Float.parseFloat(stArr[1]);

            TwoD_Node nb = new TwoD_Node(new TwoD_Point(Arrays.asList(lati, longii)), stArr[2]);
            tree.add(nb);

        }

        long start = System.currentTimeMillis();

        System.out.println(tree.findNearest(new TwoD_Point(Arrays.asList(lat, longi))));

        long end = System.currentTimeMillis();
        System.out.println("Time - " + (end - start) + " ms");

    }
}
