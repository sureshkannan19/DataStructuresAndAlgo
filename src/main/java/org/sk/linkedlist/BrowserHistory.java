package org.sk.linkedlist;

import java.util.LinkedList;

public class BrowserHistory {

    private final LinkedList<String> forwardHistory = new LinkedList<>();
    private final LinkedList<String> backwardHistory = new LinkedList<>();

    public BrowserHistory(String homepage) {
        forwardHistory.push(homepage);
    }

    public void visit(String url) {
        forwardHistory.push(url);
        backwardHistory.clear();
    }

    public String back(int steps) {
        while (!forwardHistory.isEmpty() && steps != 0) {
            backwardHistory.push(forwardHistory.pop());
            steps--;
        }
        // if steps are greater than actual history, return last visited site
        if (forwardHistory.isEmpty()) {
            forwardHistory.push(backwardHistory.pop());
        }
        return forwardHistory.peek();
    }

    public String forward(int steps) {
        while (!backwardHistory.isEmpty() && steps != 0) {
            forwardHistory.push(backwardHistory.pop());
            steps--;
        }
        return forwardHistory.peek();
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));        // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));        // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));        // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));        // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));        // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */