package kf5012;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.table.*;
class MainTableGUI extends JFrame
{ 
  public DBMain obj;
 
  
    ArrayList<MotorProblems> theProblemList;
    ArrayList<MotorInformation> tableData;
    
    
  problemTable theMarksHandler;
  
  
      private javax.swing.JButton addMotorButton;
    private javax.swing.JButton deleteMotorButton;
    private javax.swing.JButton editMotorButton;
  
  
  private JPanel topPanel;
  private JTable table;
  private JScrollPane scrollPane;
  private String[] columns = new String[3];
  private String[][] data = new String[3][3];
  JButton button = new JButton();
  public MainTableGUI(problemTable marksHandler)
  {
      DBMain obj = new DBMain();
  //  theProblemList = new ArrayList<problems>();
    theMarksHandler = marksHandler;
    
    addMotorButton = new javax.swing.JButton();
    deleteMotorButton = new javax.swing.JButton();
    editMotorButton = new javax.swing.JButton();
    
   tableData = obj.GetAllMotors();
    theProblemList = obj.GetAllProblems();
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
    
    
            

    
    
    setTitle("Motor List");
    setSize(1000,700);
    topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    getContentPane().add(topPanel);
    
    
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
getContentPane().add(panel, BorderLayout.PAGE_END);
    
    
    
    
    
    
    table = new JTable();

            table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1",null, null, null, null, null,null ,null},
                {"2",null, null, null, null, null,null ,null},
                {"3",null, null, null, null, null,null ,null},
                {"4",null, null, null, null, null,null ,null}
            },
            new String [] {"Order Number","Motor ID","Key Details", "Predicted Cost", "Problem","Status","Final Insepction Result","Final Inspection Date"}
        )
            
           {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        }
                    
                    
            );
            
            
            
            

   
            
            
            
            
            
            
            
    
           // scrollPane.setViewportView(table);
            
            addMotorButton.setText("Add Motor");

        deleteMotorButton.setText("Delete Motor");

        editMotorButton.setText("Edit Motor");
        


panel.add(addMotorButton, BorderLayout.LINE_START);

panel.add(editMotorButton, BorderLayout.CENTER);

panel.add(deleteMotorButton, BorderLayout.LINE_END);






    addMotorButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent event)
        {
           
            //maybe have to add another dialog window to grab info to add
            
                            addMotor dialog = new addMotor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();
                    }
                });
                dialog.setVisible(true);
            
                DBMain obj = new DBMain();
                //obj.AddMotor();
            
            
            
            
            
System.out.println("Add something"); 






        }
      }
    );
    
        editMotorButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent event)
        {
           
                        //maybe have to add another dialog window to grab info to add
            
                            EditMotorForm dialog = new EditMotorForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();
                    }
                });
                dialog.setVisible(true);
            
            
            
            
            
            
            
            
            //maybe have to add another dialog window to grab info to add
            
System.out.println("Edit something"); 

        }
      }
    );
        
                deleteMotorButton.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent event)
        {
        	//Gets Order ID from first colounm and passes it to problemTable for filtering 
        	int o = table.getSelectedRow();
        	Object me = table.getModel().getValueAt(o, 0);


        	//Converts Object to integer
        	int i = (Integer) me;
        	DBMain obj = new DBMain();
           obj.DeleteOrder(i);
           displayTableData(obj.GetAllMotors(),2);
            //Delete SQL in progress
            
            
            

        }
      }
    );





















        

    
    table.getColumn("Problem").setCellRenderer(new ButtonRenderer());
    table.getColumn("Problem").setCellEditor(new ButtonEditor(new JCheckBox()));
    scrollPane = new JScrollPane(table);
    topPanel.add(scrollPane,BorderLayout.CENTER);  
    
    
   // topPanel.add(addMotorButton);
    
    displayTableData(tableData,2);
    
    button.addActionListener(
      new ActionListener()
      {
        public void actionPerformed(ActionEvent event)
        {
            
//Gets motor ID from first colounm and passes it to problemTable for filtering 
int o = table.getSelectedRow();
Object me = table.getModel().getValueAt(o, 1);


//Converts Object to integer
int i = (Integer) me;

me.toString();



//Used for testing
System.out.println(me); 



//get MotorID and pass to display table data

          problemTable dialog = new problemTable(new javax.swing.JFrame(), true);
          dialog.displayTableData(theProblemList, i);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.dispose();
                     
                    }
                    
                });

                dialog.setVisible(true);
        }
      }
    );
    
    
  }
  class ButtonRenderer extends JButton implements TableCellRenderer 
  {
    public ButtonRenderer() {
      setOpaque(true);
    }
    public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {
      setText((value == null) ? "View" : value.toString());
      return this;
    }
  }
  class ButtonEditor extends DefaultCellEditor 
  {
    private String label;
    
    public ButtonEditor(JCheckBox checkBox)
    {
      super(checkBox);
    }
    public Component getTableCellEditorComponent(JTable table, Object value,
    boolean isSelected, int row, int column) 
    {
      label = (value == null) ? "View" : value.toString();
      button.setText(label);
      return button;
    }
    public Object getCellEditorValue() 
    {
      return new String(label);
    }
  }
  public static void main(String args[])
  {
      EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTableGUI frame = new MainTableGUI(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
  }
  
  
  //Dummy data used instead of database for testing 
  ArrayList<MotorInformation> getAllMotors()
  {
            ArrayList<MotorInformation> m1 = new ArrayList();
      //theProblemList.clear();
      
      
      MotorInformation d = new MotorInformation();
      
      
      d.setMotorID(1);
      d.setOrderID(902);
      d.setStatus("Active");
      d.setPredictedCost(10);
      m1.add(d);
      
      d = new MotorInformation();
      
            d.setMotorID(2);
            d.setOrderID(283);
      d.setStatus("Finished");
      d.setPredictedCost(100);
      m1.add(d);
      
            d = new MotorInformation();
      
            d.setMotorID(3);
            d.setOrderID(515);
      d.setStatus("Unknown");
      d.setPredictedCost(1000);
      m1.add(d);
      
      
      Collections.sort(m1);
      return m1;
  }
  
  
  ArrayList<MotorProblems> getAllProblems()
  {
      ArrayList<MotorProblems> pl = new ArrayList();
      //theProblemList.clear();
      
      MotorProblems p = new MotorProblems();
      
      p.setMotorID(1);
      p.setProblem("Rusty");
      p.setProblemDetails("Use wd40");
      pl.add(p);
      
      p = new MotorProblems();
      p.setMotorID(2);
      p.setProblem("Loose");
      p.setProblemDetails("Use driver");
      pl.add(p);      
      
      p = new MotorProblems();
      p.setMotorID(2);
      p.setProblem("Stuck");
      p.setProblemDetails("Use gr3ce");
      pl.add(p);
 
      Collections.sort(pl);
      
      
      
      return pl;
  }
  
  
        	void displayTableData(ArrayList<MotorInformation> tab, int mID){
		
		// Empty the existing data
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		// Some safety code missing here
                //Loop to display data to initial table 
		for(MotorInformation s: tab) {
 
			tableModel.addRow(new Object[] {s.getOrderID(),s.getMotorID(),s.getKeyDetails() ,s.getPredictedCost(),s.getProblem(), s.getStatus(),s.getFinalInspection(),s.getCompletionDate()});
                    }
                    
	}
  
  

  
  
}