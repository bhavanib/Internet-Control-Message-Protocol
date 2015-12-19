import java.applet.*;
import java.awt.*;
import java.applet.Applet; // Provides the Applet class.
import java.awt.event.*;   // Provides ActionEvent, ActionListener 
import javax.swing.*;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import javax.swing.table.*;
import java.net.*;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.lang.*;

public class icmp extends Applet implements ActionListener
{  
   int sizes,sized1,sized2,hnum,dnum,flag=0;
   private Label sources;
   private Label dest1;  
   private Label dest2;
   private Label host;
   private Label destination;
   private JButton doButtond2;
   private JButton dodo;     
   private TextField des1;
   private TextField des2;
   private TextField host1; // host
   private TextField destination1; // destination
   private Choice sou,desti1,desti2;
   private String nums;  
   private String numd1;
   private String numd2;
   private String hos;
   private String destin;
   JTable tab=new JTable(new CustomTable());
   JTable tab1=new JTable(new CustomTable());
   char[][] charValues = new char[10][10];
   boolean allowUserInput = false;
   
   public void init()  
   {  
      setSize(1200,700);
      
      sou = new Choice();
      sources = new Label("Select number of sources:");             
      sou.add("1");
      sou.add("2");
      sou.add("3");
      sou.add("4");
      sou.add("5");      
      add(sources);  
      add(sou);
      
      desti1= new Choice();
      dest1 = new Label("Select no. of dest for R1:");               
      desti1.add("1");
      desti1.add("2");
      desti1.add("3");
      add(dest1);  
      add(desti1);  
      
      desti2= new Choice();
      dest2 = new Label("Select no of dest for R2:");        
      desti2.add("1");
      desti2.add("2");
      desti2.add("3");
      doButtond2 = new JButton("Submit");  
      doButtond2.addActionListener(this);        
      add(dest2);  
      add(desti2);  
      add(doButtond2);  
          
      host = new Label("Enter source number:");        
      host1 = new TextField(4);               
      add(host);  
      add(host1);
             
      destination = new Label("Enter destination number:");        
      destination1 = new TextField(4);        
      dodo=new JButton("Start"); 
      dodo.addActionListener(this);   
      add(destination);  
      add(destination1);  
      add(dodo);  
   }  
     
   public void actionPerformed(ActionEvent event) 
   { 
      nums=sou.getSelectedItem();  
      sizes= Integer.parseInt(nums);
      System.out.println(sizes);
      repaint();
      sources.setVisible(false);
      sou.setVisible(false);
      
      numd1 = desti1.getSelectedItem();; 
      sized1= Integer.parseInt(numd1);
      System.out.println(sized1);
      repaint();
      dest1.setVisible(false);
      desti1.setVisible(false);
      numd2 =desti2.getSelectedItem();; 
      sized2= Integer.parseInt(numd2);
      System.out.println(sized2);
      repaint();
      
      dest2.setVisible(false);
      desti2.setVisible(false);
      doButtond2.setVisible(false);
      hos = host1.getText(); 
      hnum= Integer.parseInt(hos);
      System.out.println(hnum);
      repaint();
      
      host.setVisible(false);
      host1.setVisible(false);     
      destin = destination1.getText(); 
      dnum= Integer.parseInt(destin);
      flag=1;
      System.out.println(dnum);
      repaint();
      
      destination.setVisible(false);
      destination1.setVisible(false);
      dodo.setVisible(false);     
   }      
   public void paint (Graphics g)
   {       
      int u=50,v=100;
      for(int k=1;k<=sizes;k++) // dynamic hosts creation
      {
         g.setColor( Color.black );
         g.fillRect( u, v, 50, 50 );
         g.setColor( Color.white );
         String f=Integer.toString(k);
         g.drawString(f, (u+20) ,(v+30));
         g.setColor(Color.red);
         g.drawString("10.0.0."+f+"/24",(u),(v+70));
         v=v+80;           
      } 
             
      int y=350,z=100;// co-ordinates of 1st destination connected to R1
      for(int k=1;k<=sized1;k++) // dynamic creation of destinations for router1
      {
         g.setColor( Color.black );
         g.fillRect( y, z, 50, 50 );
         g.setColor( Color.white );
         int j=k+10;
         String f=Integer.toString(j);
         g.drawString(f, (y+20) ,(z+30));
         g.setColor(Color.red);
         g.drawString("11.0.0."+f+"/24",(y),(z+70));
         z=z+80;  
      }      
      
      y=350;z=340; // co-ordinates of 2nd destination connected to R1
      for(int k=1;k<=sized2;k++) // dynamic creation of  destinations for router2
      {
         g.setColor( Color.black );
         g.fillRect( y, z, 50, 50 );
         g.setColor( Color.white );
         int j=k+20;
         String f=Integer.toString(j);
         g.drawString(f, (y+20) ,(z+30));
         g.setColor(Color.red);
         g.drawString("12.0.0."+f+"/24",(y),(z+70));
         z=z+80;  
      }
      
      int x1=317; // horizontal lines from destinations towards routers
      int y1=122;            
      for(int k=1;k<=sized1;k++)
      {            
          g.setColor( Color.black );
          g.drawLine( x1,y1,x1+35,y1 );
          g.setColor( Color.black );
          if(k==1)
          g.drawLine( x1,y1,x1,175);
          else
          g.drawLine( x1,y1,x1,(y1-80*(k-1)));
          y1=y1+80;           
      } 
      
      int x2=317; // vertical lines from destinations downwards towards routers direction
      int y2=350;      
      for(int k=1;k<=sized2;k++)
      {
         g.setColor( Color.black );
         g.drawLine( x2,y2,x2+35,y2 );
         g.setColor( Color.black );
         if(k==1)
            g.drawLine( x2,y2,x2,y2-(25*k));
         else if(k==2)
            g.drawLine( x2,y2,x2,y2-(40*k));
         else
            g.drawLine( x2,y2,x2,y2-(60*k)); 
         y2=y2+80; 
      }      
      
      g.setColor( Color.black ); //lines connecting routers to destinations
      g.drawLine( 250,175,317,175 );
      g.setColor( Color.black );
      g.drawLine( 250,325,317,325 );
      
      g.setColor( Color.black ); // router1
      g.fillOval( 200, 150, 50, 50 );
      g.setColor(Color.red);
      g.drawString("10.0.0.100",(200),(150));
      
      g.setColor( Color.black ); // router2
      g.fillOval( 200, 300, 50, 50 );
      g.setColor(Color.red);
      g.drawString("10.0.0.200",(200),(300));
      
      g.setColor( Color.black ); // vertical line
      g.drawLine( 150,90,150,450 );
      g.setColor( Color.white );
      g.drawString("R1", 218 ,180);
      g.setColor( Color.white );
      g.drawString("R2", 218 ,330);     
       
      g.setColor( Color.black ); // lines connecting router and vertical line
      g.drawLine( 150,175,200,175 );
      g.setColor( Color.black );
      g.drawLine( 150,325,200,325 );
        
      int m=90,n=125;
      for(int k=1;k<=sizes;k++) // hosts to vertical line connection
      {
         g.setColor( Color.black );
         g.drawLine( m,n,m+60,n );
         n=n+75;
      }
      
      if(flag==1) //changing colour of host and destination
      {  
         add( tab );
         add( tab1 );
         if(dnum/10==2) 
         {
            tab1.setValueAt("10.0.0.200", 2,1);
         }
         else 
         {
            tab1.setValueAt("10.0.0.100", 2,1);
         }
         validate();
         
         u=50;v=100;
         g.setColor( Color.blue );
         g.fillRect( u, v+(hnum-1)*80, 50, 50 );
         v=v+(hnum-1)*80;
         g.setColor(Color.white);
         String h=Integer.toString(hnum);
         g.drawString(h, (u+20) ,(v+30));
         
         y=350;z=100;         
         if((dnum/10)==1)
         { 
            g.setColor(Color.blue);
            g.fillRect(y,(z+((dnum-10)-1)*80),50,50);
            z=z+((dnum-10)-1)*80;               
         }
         else
         {
            y=350;z=340;
            g.setColor(Color.blue);
            g.fillRect(y,(z+(((dnum-20)-1))*80),50,50); 
            z=z+(((dnum-20)-2))*80 ;
         }  
         
         g.setColor(Color.white);
         String dnumb=Integer.toString(dnum);
         g.drawString(dnumb, (y+20) ,(z+30)); 
       
         int ab=100;
         int bc=((hnum-1)*80)+115;
         int mm=100;
         int nn=((hnum-1)*80)+120;      
                            
         if(hnum==1) //for host1 sending packet
         {
            ab=115;
            bc=120;
            mm=120;
            nn=125;         
            while(ab<=140)
            {
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
   		      {
   			      Thread.sleep (500);
   		      }
               catch (InterruptedException ex)
   		      {
   	      	// does nothing
    		      }
               g.clearRect( ab, bc, 12, 12 );
               g.setColor( Color.black );
               g.drawLine( mm-10,nn,mm+10,nn);
               mm=mm+10;
               ab=ab+10;
            }
            
            while(bc<=170)
            {
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
   		      {
   			      Thread.sleep (500);
   		      }
               catch (InterruptedException ex)
   		      {
   	      	// does nothing
    		      }
               g.clearRect( ab, bc, 12, 12 );
               g.setColor( Color.black );
               g.drawLine( mm,nn-10,mm,nn+15 );
               nn=nn+20;
               bc=bc+25;
            } 
            
            while(ab<=190)
            {
               bc=170;
               mm=170;
               nn=175;
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
   		      {
   			      Thread.sleep (500);
   		      }
               catch (InterruptedException ex)
   		      {
   	      	// does nothing
    		      }
               g.clearRect( ab, bc, 12, 12 );
               g.setColor( Color.black );
               g.drawLine( mm-10,nn,mm+25,nn );
               mm=mm+20;
               ab=ab+20;
            }           
         }
         
         else //for other hosts sending packets
         {
            while(ab<=140)
            {
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
   		      {
   			      Thread.sleep (500);
   		      }
               catch (InterruptedException ex)
   		      {
   	      	// does nothing
    		      }
               g.clearRect( ab, bc, 12, 12 );
               g.setColor( Color.black );
               g.drawLine( mm-10,nn,mm+20,nn );
               mm=mm+10;
               ab=ab+10;
            }
            
            while(bc>=170)
            {
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
   		      {
   			      Thread.sleep (500);
   		      }
               catch (InterruptedException ex)
   		      {
   	      	// does nothing
    		      }
               g.clearRect( ab, bc, 12, 12 );
               g.setColor( Color.black );
               g.drawLine( mm,nn-30,mm,nn-10 );
               nn=nn-10;
               bc=bc-25;
            } 
            
            while(ab<=190)
            {
               bc=170;
               mm=170;
               nn=175;
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
   		      {
   			      Thread.sleep (500);
   		      }
               catch (InterruptedException ex)
   		      {
   	      	// does nothing
    		      }
               g.clearRect( ab, bc, 12, 12 );
               g.setColor( Color.black );
               g.drawLine( mm-10,nn,mm+25,nn );
               mm=mm+20;
               ab=ab+20;
            } 
         }//closing else of(hnum==1)
         
         if((dnum/10)==2) //if destination is connected to router2
         {
            if(hnum==1) //if host1 sends a packet
            {
               ab=190; //redirection of packet from router1 to vertical line
               bc=170; 
               while(ab>=140)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   { 
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	      // does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm-10,nn,mm+15,nn );
                  mm=mm-10;
                  ab=ab-20;
               }
               
               ab=140; //redirection of packet down the vertical line
               bc=170; 
               while(bc<=330)
               {
                  mm=150;
                  nn=170;
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn-10,mm,nn+30 );
                  nn=nn+20;
                  bc=bc+25;
               }
                 
               ab=140; //redirection of packet towards router2
               bc=320;
               while(ab<=190)
               {
                  mm=115;
                  nn=125;
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm-10,nn,mm+35,nn );
                  mm=mm+10;
                  ab=ab+20;  
               }     
               
               if(dnum/10==2)
               {
                  ab=250;
                  bc=320;
                  while(ab<=317) //move from router to line horizontally
                  {
                     g.setColor( Color.black );
                     g.fillRect( ab, bc, 12, 12 );
                     try
                		{
                			 Thread.sleep (500);
                 		}
                     catch (InterruptedException ex)
                		{
                 	   // does nothing
                		}
                     g.clearRect( ab, bc, 12, 12 );
                     g.setColor( Color.black );
                     g.drawLine( mm-10,nn,mm+35,nn );
                     mm=mm+10;
                     ab=ab+10;
                  }
                    
                  while(bc<=350) // move down the line a little
                  {
                     g.setColor( Color.black );
                     g.fillRect( ab, bc, 12, 12 );
                     try
                     {
                 		   Thread.sleep (500);
                 		}
                     catch (InterruptedException ex)
                		{
                 	   // does nothing
                	   }
                     g.clearRect( ab, bc, 12, 12 );
                     g.setColor( Color.black );
                     bc=bc+10;
                  }
                  if((dnum%10)==1) //if dest1
                  {                  
                     while(ab<=352)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                        {
                  		   Thread.sleep (500);
                  	   }
                        catch (InterruptedException ex)
                  	   {
                      	// does nothing
                  	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        ab=ab+10;
                     }
                  }
                  if((dnum%10)==2) //if dest2
                  {
                     while(bc<=430)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                        {
                        	Thread.sleep (500);
                     	}
                        catch (InterruptedException ex)
                     	{
                        // does nothing
                        }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        bc=bc+10;
                     }
                        
                     while(ab<=352)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                  		{
                  		   Thread.sleep (500);
                  		}
                        catch (InterruptedException ex)
                  		{
                  	  	// does nothing
                   	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        ab=ab+10;
                     }
                  }              
                  if((dnum%10)==3)  
                  {
                     while(bc<=510)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                        {
                   			Thread.sleep (500);
                    		}
                        catch (InterruptedException ex)
                    		{
                    	   // does nothing
                   	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        bc=bc+10;
                     }
                    
                     while(ab<=352)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                  		{ 
                           Thread.sleep (500);
                  		}
                        catch (InterruptedException ex)
                  		{
                  	 	// does nothing
                   	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        ab=ab+10;
                     }
                  }              
               }//endif dnum=2
                       
               ab=100; // packet to move via first horizontal line
               bc=170; 
               while(ab>=140)
               {
                  g.setColor( Color.black );
                  g.drawString("Redirect", ab ,bc);
                  try
         		   { 
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	      // does nothing
          		   }
                  g.setColor(getBackground());
                  g.drawString("Redirect", ab ,bc);
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+25,nn );
                  mm=mm-20;
                  ab=ab-20;
               }
               
               ab=140;
               bc=170; 
               while(bc>=120)
               {
                  mm=150;
                  nn=170;
                  g.setColor( Color.black );
                  g.drawString("Redirect", ab ,bc);
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.setColor( getBackground() );
                  g.drawString("Redirect", ab ,bc);
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm,nn+30 );
                  nn=nn-20;
                  bc=bc-25;
               } 
               
               ab=140;
               bc=120;
               while(ab>=100)
               {
                  mm=115;
                  nn=125;
                  g.setColor( Color.black );
                  g.drawString("Redirect", ab ,bc);
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.setColor( getBackground() );
                  g.drawString("Redirect", ab ,bc);
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+35,nn );
                  mm=mm-10;
                  ab=ab-20;
               }//end while of redirect message
               
               ab=100;
               bc=120;
               mm=100;
               nn=125;            
               while(ab<=140)//Beginning of second packet
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
      		      {
      			      Thread.sleep (500);
      		      }
                  catch (InterruptedException ex)
      		      {
      	      	// does nothing
       		      }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+11,nn );
                  mm=mm+10;
                  ab=ab+10;
               }
               
               while(bc<=330)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
      		      {
      			      Thread.sleep (500);
      		      }
                  catch (InterruptedException ex)
      		      {
      	      	// does nothing
       		      }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm,nn+15 );
                  nn=nn+20;
                  bc=bc+25;
               } 
               
               while(ab<=190)
               {
                  bc=320;
                  mm=320;
                  nn=175;
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
      		      {
      			      Thread.sleep (500);
      		      }
                  catch (InterruptedException ex)
      		      {
      	      	// does nothing
       		      }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+25,nn );
                  mm=mm+20;
                  ab=ab+20;
               }  
               
               
                                    
            }//end of if hnum==1
            
            else //if hnum!==1
            {
               ab=190; //redirection of packet from router1 to vertical line
               bc=170; 
               while(ab>=140)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   { 
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	      // does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+15,nn );
                  mm=mm-10;
                  ab=ab-20;
               }
               
               ab=140; //redirection of packet down the vertical line
               bc=170; 
               while(bc<=330)
               {
                  mm=150;
                  nn=170;
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm,nn+30 );
                  nn=nn+20;
                  bc=bc+25;
               }
                 
               ab=140; //redirection of packet towards router2
               bc=320;
               while(ab<=190)
               {
                  mm=115;
                  nn=125;
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+35,nn );
                  mm=mm+10;
                  ab=ab+20;  
               }   
               
               if(dnum/10==2)
               {
                  ab=250;
                  bc=320;
                  while(ab<=317) //move from router to line horizontally
                  {
                     g.setColor( Color.black );
                     g.fillRect( ab, bc, 12, 12 );
                     try
                		{
                			 Thread.sleep (500);
                 		}
                     catch (InterruptedException ex)
                		{
                 	   // does nothing
                		}
                     g.clearRect( ab, bc, 12, 12 );
                     g.setColor( Color.black );
                     ab=ab+10;
                  }
                    
                  while(bc<=350) // move down the line a little
                  {
                     g.setColor( Color.black );
                     g.fillRect( ab, bc, 12, 12 );
                     try
                     {
                 		   Thread.sleep (500);
                 		}
                     catch (InterruptedException ex)
                		{
                 	   // does nothing
                	   }
                     g.clearRect( ab, bc, 12, 12 );
                     g.setColor( Color.black );
                     bc=bc+10;
                  }
                  if((dnum%10)==1) //if dest1
                  {                  
                     while(ab<=352)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                        {
                  		   Thread.sleep (500);
                  	   }
                        catch (InterruptedException ex)
                  	   {
                      	// does nothing
                  	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        ab=ab+10;
                     }
                  }
                  if((dnum%10)==2) //if dest2
                  {
                     while(bc<=430)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                        {
                        	Thread.sleep (500);
                     	}
                        catch (InterruptedException ex)
                     	{
                        // does nothing
                        }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        bc=bc+10;
                     }
                        
                     while(ab<=352)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                  		{
                  		   Thread.sleep (500);
                  		}
                        catch (InterruptedException ex)
                  		{
                  	  	// does nothing
                   	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        ab=ab+10;
                     }
                  }              
                  if((dnum%10)==3)  
                  {
                     while(bc<=510)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                        {
                   			Thread.sleep (500);
                    		}
                        catch (InterruptedException ex)
                    		{
                    	   // does nothing
                   	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        bc=bc+10;
                     }
                    
                     while(ab<=352)
                     {
                        g.setColor( Color.black );
                        g.fillRect( ab, bc, 12, 12 );
                        try
                  		{ 
                           Thread.sleep (500);
                  		}
                        catch (InterruptedException ex)
                  		{
                  	 	// does nothing
                   	   }
                        g.clearRect( ab, bc, 12, 12 );
                        g.setColor( Color.black );
                        ab=ab+10;
                     }
                  }              
               }//endif dnum=2   
                   
               ab=100; // packet to move via first horizontal line
               bc=170; 
               while(ab>=140)
               {
                  g.setColor( Color.black );
                  g.drawString("Redirect", ab ,bc);
                  try
         		   { 
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	      // does nothing
          		   }
                  g.setColor( getBackground() );
                  g.drawString("Redirect", ab ,bc);
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+25,nn );
                  mm=mm-20;
                  ab=ab-20;
               }
               
               ab=140;
               bc=170; 
               while(bc<=(110+((hnum-1)*80)))
               {
                  mm=150;
                  nn=170;
                  g.setColor( Color.black );
                  g.drawString("Redirect", ab ,bc);
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.setColor( getBackground() );
                  g.drawString("Redirect", ab ,bc);
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm,nn+30 );
                  nn=nn+20;
                  bc=bc+25;
               } 
               
               ab=140;
               while(ab>=100)
               {
                  mm=115;
                  nn=125;
                  g.setColor( Color.black );
                  g.drawString("Redirect", ab ,bc);
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.setColor( getBackground() );
                  g.drawString("Redirect", ab ,bc);
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+35,nn );
                  mm=mm-10;
                  ab=ab-20;
               }//end while of redirect message
               
               ab=100;
               bc=110+((hnum-1)*80);
               while(ab<=140)//beginning of second message
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
      		      {
      			      Thread.sleep (500);
      		      }
                  catch (InterruptedException ex)
      		      {
      	      	// does nothing
       		      }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+11,nn );
                  mm=mm+10;
                  ab=ab+10;
               }
               
               ab=140;
               bc=110+((hnum-1)*80);
               //m=350;
               //n=350;
               while(bc<=330)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
      		      {
      			      Thread.sleep (500);
      		      }
                  catch (InterruptedException ex)
      		      {
      	      	// does nothing
       		      }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  //g.drawLine( mm,nn,mm,nn+15 );
                  //nn=nn+20;
                  bc=bc+25;
               } 
               
               while(ab<=190)
               {
                  bc=320;
                  mm=320;
                  nn=175;
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
      		      {
      			      Thread.sleep (500);
      		      }
                  catch (InterruptedException ex)
      		      {
      	      	// does nothing
       		      }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  g.drawLine( mm,nn,mm+25,nn );
                  mm=mm+20;
                  ab=ab+20;
               }//end of 2nd message                                   
            }//end of if hnum!==1  
                         
         }//end of if dnum==2 
         if((dnum/10)==1)//movement of packet from router1 to destination
         {  
            int k=dnum%10;
            ab=317;
            bc=175;
            if(k==1)
            {               
               while(bc>=118)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }                 
                  g.clearRect( ab, bc, 12, 12 );
                  g.drawLine(ab+1,bc+1,ab+1,bc-9);                    
                  bc=bc-10;
               }
               
               while(ab<=352)
               {  
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.drawLine(ab,bc,ab+10,bc);
                  ab=ab+10;
               }
            }//endif for 11
            if(k==2)
            {
               while(bc<=202)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.drawLine(ab,bc,ab,bc+10);
                  bc=bc+10;
               }
               while(ab<=330)
               {  
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.drawLine(ab,bc-3,ab+10,bc-3);
                  ab=ab+10;
               }
            }//endif k==2
            if(k==3)
            {
               while(bc<=282)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			  Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	     	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.drawLine(ab,bc,ab,bc+10);
                  bc=bc+10;
               }
               
               while(ab<=352)
               {  
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
         		   {
         			   Thread.sleep (500);
         		   }
                  catch (InterruptedException ex)
         		   {
         	    	// does nothing
          		   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.drawLine(ab,bc,ab+10,bc);
                  ab=ab+10;
               }
            }//endif k==3
         }//end for dnum=1
         if(dnum/10==2)
         {
            ab=250;
            bc=325;
            while(ab<=317) //move from router to line horizontally
            {
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
          		{
          			 Thread.sleep (500);
           		}
               catch (InterruptedException ex)
          		{
           	   // does nothing
          		}
               g.clearRect( ab, bc, 12, 12 );
               ab=ab+10;
            }
              
            while(bc<=350) // move down the line a little
            {
               g.setColor( Color.black );
               g.fillRect( ab, bc, 12, 12 );
               try
               {
           		   Thread.sleep (500);
           		}
               catch (InterruptedException ex)
          		{
           	   // does nothing
          	   }
               g.clearRect( ab, bc, 12, 12 );
               bc=bc+10;
            }
            if((dnum%10)==1) //if dest1
            {                  
               while(ab<=352)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
                  {
            		   Thread.sleep (500);
            	   }
                  catch (InterruptedException ex)
            	   {
                	// does nothing
            	   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  ab=ab+10;
               }
            }
            if((dnum%10)==2) //if dest2
            {
               while(bc<=430)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
                  {
                  	Thread.sleep (500);
               	}
                  catch (InterruptedException ex)
               	{
                  // does nothing
                  }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  bc=bc+10;
               }
                  
               while(ab<=352)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
            		{
            		   Thread.sleep (500);
            		}
                  catch (InterruptedException ex)
            		{
            	  	// does nothing
             	   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  ab=ab+10;
               }
            }              
            if((dnum%10)==3)  
            {
               while(bc<=510)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
                  {
             			Thread.sleep (500);
              		}
                  catch (InterruptedException ex)
              		{
              	   // does nothing
             	   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  bc=bc+10;
               }
              
               while(ab<=352)
               {
                  g.setColor( Color.black );
                  g.fillRect( ab, bc, 12, 12 );
                  try
            		{ 
                     Thread.sleep (500);
            		}
                  catch (InterruptedException ex)
            		{
            	 	// does nothing
             	   }
                  g.clearRect( ab, bc, 12, 12 );
                  g.setColor( Color.black );
                  ab=ab+10;
               }
            }              
         }//endif dnum=2        
      }//end flag
   }//end actionperformed
}//end class

class CustomTable extends AbstractTableModel 
{
    private String[] columnNames = {"Network Destination","Gateway","Interface"};
    private Object[][] data = {{"Network Destination","Gateway","Interface"},{"11.0.0.0/24", "10.0.0.100","eth0"},{"12.0.0.0/24","10.0.0.100","eth0"}};

    public int getColumnCount() 
    {
       return columnNames.length;
    }

    public int getRowCount() 
    {
       return data.length;
    }

    public String getColumnName(int col) 
    {
       return columnNames[col];
    }

    public Object getValueAt(int row, int col) 
    {
       return data[row][col];
    }

    public Class getColumnClass(int c) 
    {
       return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) 
    {
       if (col < 2) 
       {
          return false;
       } 
       else 
       {
          return true;
       }
    }

    public void setValueAt(Object value, int row, int col) 
    {
       try
       {
          Thread.sleep(500); 
       }
       catch(InterruptedException ex) 
       { 
       //does nothing
       }        
       data[row][col] = value;
       fireTableCellUpdated(row, col);
    }
}