package org.sk.linkedlist;

import java.util.LinkedHashMap;

public class BrowserHistoryWithHashMap {

    private int currentPage = 0;
    private final LinkedHashMap<Integer, String> history = new LinkedHashMap<>();

    public BrowserHistoryWithHashMap(String homepage) {
        history.put(++currentPage, homepage);
    }

    public void visit(String url) {
        history.put(++currentPage, url);
        if (currentPage != history.size()) {
            int currentSize = history.size();
            for (int i = currentPage + 1; i <= currentSize; i++) {
                history.remove(i);
            }
        }
    }

    public String back(int steps) {
        currentPage = Math.max(1, currentPage - steps);
        return history.get(currentPage);
    }

    public String forward(int steps) {
        currentPage = Math.min(history.size(), currentPage + steps);
        return history.get(currentPage);
    }
    public static void main(String[] args) {
        BrowserHistoryWithHashMap browserHistory = new BrowserHistoryWithHashMap("leetcode.com");
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

        browserHistory = new BrowserHistoryWithHashMap("esgriv.com");
        browserHistory.visit("cgrt.com");
        browserHistory.visit("tip.com");
        System.out.println(browserHistory.back(9));
        browserHistory.visit("kttzxgh.com");
        System.out.println(browserHistory.forward(7));
        browserHistory.visit("crqje.com");
        browserHistory.visit("iybch.com");
        System.out.println(browserHistory.forward(5));
        browserHistory.visit("uun.com");
        System.out.println(browserHistory.back(10));
        browserHistory.visit("hci.com");
        browserHistory.visit("whula.com");
        System.out.println(browserHistory.forward(10));
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */