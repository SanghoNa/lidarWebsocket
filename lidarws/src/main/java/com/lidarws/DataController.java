package com.lidarws;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.ArrayList;

import sensr_proto.Output;
import sensr_proto.Output.OutputMessage;
import sensr_proto.Type.LabelType;
import sensr_proto.Type.Object;
import sensr_proto.PointCloudOuterClass;
import sensr_proto.PointCloudOuterClass.PointResult;
import sensr_proto.PointCloudOuterClass.PointResult.PointCloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

import processing.core.PVector;

public class DataController {

      private int peopleNum;
      private int peopleNumCopy;

      private ArrayList<PVector> peoplePos;
      private ArrayList<PVector> peopleVelocity;
      private ArrayList<PVector> peopleSize;
      private ArrayList<PVector> PeoplePoints;

      private ArrayList<PVector> peoplePosCopy;
      private ArrayList<PVector> peopleVelocityCopy;
      private ArrayList<PVector> peopleSizeCopy;
      private ArrayList<PVector> PeoplePointsCopy;

      private ArrayList<PVector> pointCloud;
      private ArrayList<PVector> pointCloudCopy;

      Message.Builder builder;
      List<Object> objectList;
      List<PointCloud> cloudList;

      private boolean isPointData = false;
      private boolean isPointCloudData = false;

      public DataController()
      {
            //dataPars(_message);
            peopleNumCopy = 0;
            peoplePosCopy = new ArrayList<>();
            peopleVelocityCopy = new ArrayList<>();
            peopleSizeCopy = new ArrayList<>();
            PeoplePointsCopy = new ArrayList<>();
      }

      public void dataPars(ByteBuffer message, String _typeName)
      {
            if(_typeName == "object")
            {
                  try
                  {
                        OutputMessage data =  Output.OutputMessage.parseFrom(message);

                        if(data.hasStream())
                        {
                              objectList = data.getStream().getObjectsList();
                              
                              //reset data field for peoples.
                              peopleNum = 0;
                              peoplePos = new ArrayList<>();
                              peopleVelocity = new ArrayList<>();
                              peopleSize = new ArrayList<>();
                              PeoplePoints = new ArrayList<>();

                              if(objectList.size() == 0)
                              {
                                    peopleNum = 0;
                                    peopleNumCopy = 0;
                                    isPointData = true; // for no one in space.
                                    //setArrayReset();
                              }
                              else
                              {
                                    for (Object object : objectList) {
                                    

                                    if(object.getLabel() == LabelType.LABEL_PEDESTRIAN)
                                          {
                                                // add people cnt.
                                                peopleNum++; 
                                                // add people Pos.
                                                PVector tempPVector = new PVector(object.getBbox().getPosition().getX(), 
                                                                                    object.getBbox().getPosition().getY());
                                                peoplePos.add(tempPVector);
                                                // add people velocity.
                                                PVector tempVelocity = new PVector(object.getVelocity().getX(), 
                                                                                    object.getVelocity().getY());
                                                peopleVelocity.add(tempVelocity);

                                                PVector tempSize = new PVector(object.getBbox().getSize().getX(), 
                                                                              object.getBbox().getSize().getY(), 
                                                                              object.getBbox().getSize().getZ());
                                                peopleSize.add(tempSize);

                                          

                                                ByteString peoplePointsList = object.getPoints();
                                                
                                                byte[] tempbyteArr = peoplePointsList.toByteArray();
                                                // ByteBuffer buffer = ByteBuffer.wrap(tbarr);

                                                //ByteBuffer buffer = object.getPoints().asReadOnlyByteBuffer();

                                                //System.out.println("byteArray length===" + object.getPoints().size());
                                          
                                                
                                                for(int i = 0; i<object.getPoints().size()-4*3*5; i+=4*3*5) //byte[4] * (x, y, z)
                                                {
                                                      //System.out.println("byteArray===" + buffer.getFloat(i));
                                                      //List<Float> floaList = buffer.get(i);
                                                      
                                                      int asInt1 = (tempbyteArr[i] & 0xff)
                                                                  | ((tempbyteArr[i+1] & 0xff) << 8)
                                                                  | ((tempbyteArr[i+2] & 0xff) << 16)     
                                                                  | ((tempbyteArr[i+3] & 0xff) << 24);
                                                      float asFloat1 = Float.intBitsToFloat(asInt1);

                                                      int asInt2 = (tempbyteArr[i+4] & 0xff)
                                                                  | ((tempbyteArr[i+5] & 0xff) << 8)
                                                                  | ((tempbyteArr[i+6] & 0xff) << 16)     
                                                                  | ((tempbyteArr[i+7] & 0xff) << 24);
                                                      float asFloat2 = Float.intBitsToFloat(asInt2);

                                                      int asInt3 = (tempbyteArr[i+8] & 0xff)
                                                                  | ((tempbyteArr[i+9] & 0xff) << 8)
                                                                  | ((tempbyteArr[i+10] & 0xff) << 16)     
                                                                  | ((tempbyteArr[i+11] & 0xff) << 24);
                                                      float asFloat3 = Float.intBitsToFloat(asInt3);

                                                      
                                                      PVector point = new PVector(asFloat1, asFloat2, asFloat3);
                                                                                    
                                                      PeoplePoints.add(point);
                                                }
                                                peopleNumCopy = peopleNum;
                                                peoplePosCopy = (ArrayList<PVector>)peoplePos.clone();
                                                peopleVelocityCopy = (ArrayList<PVector>)peopleVelocity.clone();
                                                peopleSizeCopy = (ArrayList<PVector>)peopleSize.clone();
                                                PeoplePointsCopy = (ArrayList<PVector>)PeoplePoints.clone();
                                                isPointData = true;

                                                /* 
                                                for (byte point : peoplePoints) {
                                                            System.out.println(point);
                                                }*/
                                                // System.out.println( "people points length==="+ peoplePoints.size());
                                          }
 
                                    }

                              }
                        
                              
                        }
                  }catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                  }
            }
            else if(_typeName == "cloud")
            {
                  try
                  {
                        PointResult data = PointCloudOuterClass.PointResult.parseFrom(message);
                        cloudList = data.getPointsList();

                        ByteString points;
                        byte[] tempbyteArr;
                        pointCloud = new ArrayList<>();

                        for (int i = 0; i < cloudList.size(); i++) {
                              //System.out.println( "point type==="+cloudList.get(i).getTypeValue() );
                              //System.out.println( "point size==="+cloudList.get(i).getPoints().size() );
                              
                              points = cloudList.get(i).getPoints();
                              tempbyteArr = points.toByteArray();
                              for (int j = 0; j < tempbyteArr.length - 4*3*5; j+= 4*3*5) {
                                   
                                    int asInt1 = (tempbyteArr[j] & 0xff)
                                                            | ((tempbyteArr[j+1] & 0xff) << 8)
                                                            | ((tempbyteArr[j+2] & 0xff) << 16)     
                                                            | ((tempbyteArr[j+3] & 0xff) << 24);
                                                float asFloat1 = Float.intBitsToFloat(asInt1);

                                                int asInt2 = (tempbyteArr[i+4] & 0xff)
                                                            | ((tempbyteArr[j+5] & 0xff) << 8)
                                                            | ((tempbyteArr[j+6] & 0xff) << 16)     
                                                            | ((tempbyteArr[j+7] & 0xff) << 24);
                                                float asFloat2 = Float.intBitsToFloat(asInt2);

                                                int asInt3 = (tempbyteArr[j+8] & 0xff)
                                                            | ((tempbyteArr[j+9] & 0xff) << 8)
                                                            | ((tempbyteArr[j+10] & 0xff) << 16)     
                                                            | ((tempbyteArr[j+11] & 0xff) << 24);
                                                float asFloat3 = Float.intBitsToFloat(asInt3);

                                                 
                                                PVector point = new PVector(asFloat1, asFloat2, asFloat3);

                                                pointCloud.add(point);
                              }
                              
                        }
                        pointCloudCopy = (ArrayList<PVector>)pointCloud.clone();
                        isPointCloudData = true;
                        

                  }catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                  } 
            }

            
      } 

      /**
	 * 
	 * return peoples position. PVector x, y
	 */
      public ArrayList<PVector> getObjectPos()
      {
           return peoplePosCopy;
      }

      /**
	 * 
	 * return peoples velocity. PVector x, y
	 */
      public ArrayList<PVector> getObjectVelocity()
      {
           return peopleVelocityCopy;
      }

      /**
	 * 
	 * return size of peoples from Bbox. PVector x, y, z
	 */
      public ArrayList<PVector> getObjectSize()
      {
           return peopleSizeCopy;
      }

      /**
	 * 
	 * return Points of peoples. PVector x, y, z
	 */
      public ArrayList<PVector> getObjectPoints()
      {
           return PeoplePointsCopy;
      }

      /**
	 * 
	 * return num of peoples. int
	 */
      public int getObjectNum()
      {
           return peopleNumCopy;
      }

      /**
	 * 
	 * return Points of evironment. PVector x, y, z
	 */
      public ArrayList<PVector> getCloudPoints()
      {
           return pointCloudCopy;
      }


      public boolean isPointDataHas()
      {
            return isPointData;
      }

      public boolean isPointCloudDataHas()
      {
            return isPointCloudData;
      }

      public void setArrayReset()
      {
            isPointData = true; // for no one in space.
            peopleNumCopy = 0;
            peoplePosCopy = new ArrayList<>();
            peopleVelocityCopy = new ArrayList<>();
            peopleSizeCopy = new ArrayList<>();
            PeoplePointsCopy = new ArrayList<>();
      }

}
