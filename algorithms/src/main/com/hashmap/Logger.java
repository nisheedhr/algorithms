package com.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receive stream of messages along with its timestamps, 
 * each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed 
in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.
 * @author nraveend
 *
 */
public class Logger {

  private Map<String, Integer> lookup = new HashMap<>();
  /** Initialize your data structure here. */
  public Logger() {
      
  }
  
  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
      If this method returns false, the message will not be printed.
      The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
     boolean print = false;
     if (!lookup.containsKey(message)) {
       print = true;
       lookup.put(message, timestamp);
       print = true;
     } else {
       int last = lookup.get(message);
       if (timestamp - last >= 10) {
         print = true;
         lookup.put(message, timestamp);
       }
     }
     
     return print;
  }
}

/**
* Your Logger object will be instantiated and called as such:
* Logger obj = new Logger();
* boolean param_1 = obj.shouldPrintMessage(timestamp,message);
*/