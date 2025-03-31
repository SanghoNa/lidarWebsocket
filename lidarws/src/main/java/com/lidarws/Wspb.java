package com.lidarws;

import processing.core.*;

public class Wspb extends Thread{
      
      PApplet parent;

      public Wspb(PApplet _parent)
      {
            parent = _parent;
            System.out.println("welcome lidar websocket connect");

      }

      public void sayHello()
      {
            System.out.println("Hello!!");
      }



}
