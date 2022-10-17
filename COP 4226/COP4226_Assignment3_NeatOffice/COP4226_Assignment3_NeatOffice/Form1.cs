using assignment_3;
using System.Drawing.Printing;
using System.Windows.Forms;

namespace COP4226_Assignment3_NeatOffice
{
    public partial class Form1 : Form
    {
        private long result;
        private String calculator_contents;
        private GraphAlgorithms algos;
        private Calculator_Logic calculator;
        private Calculator_Logic calculator_logic;
        public Form1()
        {
            InitializeComponent();
            this.algos = new GraphAlgorithms(toolStripProgressBar1, toolStripStatusLabel2, statusStrip2);
            this.calculator = new Calculator_Logic();
            result = 0;
        }

        private void textBox3_Click(object sender, EventArgs e)
        {

            calculator_textbox.Text = "";
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            calculator_textbox.Text += "";
        }

        //Digit 0-9 and "." decimal buttons (Change to one function with multiple event handlers
        private void digit1_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "1";
        }

        private void digit2_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "2";
        }

        private void digit3_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "3";
        }

        private void digit4_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "4";
        }

        private void digit5_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "5";
        }

        private void digit6_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "6";
        }

        private void digit7_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "7";
        }

        private void digit8_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "8";
        }

        private void digit9_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "9";
        }

        private void digit0_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "0";
        }

        private void decimalPoint_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += ".";
        }


        // + - x / Operation buttons
        private void plus_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "+";
        }

        private void minus_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "-";
        }

        private void multiply_Click(object sender, EventArgs e)
        {
            //Might need to switch to asterisk
            calculator_textbox.Text += "x";
        }

        private void divide_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text += "�";
        }
        //-------------------------------------------------------------

        //Calculates the difference between the from and to date
        private void date_difference_calculation(object sender, EventArgs e)
        {
            if (((DateTimePicker)sender).ContainsFocus)
                dateUpDown.Value = (toDate.Value - fromDate.Value).Days + 1;
        }
        private void dateUpDown_ValueChange(object sender, EventArgs e)
        {
            if (dateUpDown.ContainsFocus)
            {
                decimal num = dateUpDown.Value;

                if (num < 0)
                    fromDate.Value = toDate.Value.AddDays((double)num);
                else if (num > 0)
                {
                    toDate.Value = fromDate.Value.AddDays((double)num);
                }
                else
                    toDate.Value = fromDate.Value;

            }
        }
        //------------------------------------------------------------------------------------------------
        //-----------------------------Below needs to be refactored-----------------------------------------------

        //Calculator

        private void calculate_result_handler(object sender, EventArgs e)
        {
            String result = calculator.calculate_result(sender, calculator_textbox, this.calculator_contents);
            calculator_textbox.Text = result;
            calculator_contents = result;
        }
        private void operator_handler(object sender, EventArgs e)
        {
            Calculator_Logic.insert_operator(sender, calculator_textbox);
        }
        private void Toolstrip_Operator_Handler(object sender, EventArgs e)
        {
            Calculator_Logic.insert_nonbinary_function(sender, calculator_textbox);
        }
        private void digit_handler(object sender, EventArgs e)
        {
            if (calculator_textbox.Text == "0" || calculator_textbox.Text == "NaN" || calculator_textbox.Text == "infinity")
                calculator_textbox.Clear();
            Button button = sender as Button;
            calculator_textbox.Text += button.Text;
        }
        private void handle_clear(object sender, EventArgs e)
        {
            calculator_textbox.Text = 0.ToString();
            this.calculator_contents = 0.ToString();
            calculator.calculator_history.Clear();
        }
        private void button2_Click(object sender, EventArgs e)
        {
            calculator_textbox.Text = 0.ToString();
            this.calculator_contents = calculator_textbox.Text;
        }
        //-----------------------------Above needs to be refactored-----------------------------------------------

        //Appearance Settings
        private void change_background_color(object sender, EventArgs e)
        {
            ToolStripMenuItem apperance_item = sender as ToolStripMenuItem;
            ColorDialog colorDialog = new ColorDialog();
            if (colorDialog.ShowDialog() == DialogResult.OK)
                switch (apperance_item.Name)
                {
                    case "calculatorBackground":
                        horizontal_container.Panel1.BackColor = colorDialog.Color;
                        break;
                    case "dayCounterBackground":
                        horizontal_container.Panel2.BackColor = colorDialog.Color;
                        break;
                    case "graphBackground":
                        vertical_container.Panel2.BackColor = colorDialog.Color;
                        break;
                }
        }

        //Calculator History
        private void print_calculator_history(object sender, EventArgs e)
        {
            PrintDialog PrintDialog1 = new PrintDialog();
            PrintDocument printDoc = new PrintDocument();
            PrintDialog1.ShowDialog();
        }

        private void open_calculator_history(object sender, EventArgs e)
        {
            openFileDialog1.Filter = "txt files (*.txt)|*.txt";
            openFileDialog1.Multiselect = false;
            string[] lines = File.ReadAllLines(openFileDialog1.FileName);
            foreach (string line in lines)
            {
                calculator.calculator_history.Add(line);
            }
        }

        private void save_calculator_history(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                TextWriter tw = new StreamWriter(saveFileDialog1.FileName);
                foreach (String s in calculator.calculator_history)
                    tw.WriteLine(s);
                tw.Close();
            }
        }



        //------code to be edited below-----------------------------------------------------------------------
        //Bottom StatusStrip
        private void timer1_Tick(object sender, EventArgs e)
        {
            toolStripStatusLabel1.Text = $"Hello! Today is {DateTime.Today.ToLongDateString()}. The time is: {DateTime.Now.ToLongTimeString()}";
        }
        

        
        private void change_calculator_font(object sender, EventArgs e)
        {
            FontDialog font_dialog = new FontDialog();
            if (font_dialog.ShowDialog() == DialogResult.OK)
                foreach (Control control_item in tableLayoutPanel1.Controls)
                {
                    control_item.Font = font_dialog.Font;
                }

        }

        
        /*
        //Open Files
        private void Open_Multiple_Files(object sender, EventArgs e)
        {
            DialogResult result = openFileDialog1.ShowDialog();
            if (result == DialogResult.OK)
            {
                foreach (String file in openFileDialog1.FileNames)
                {
                    try
                    {
                        listBox1.Items.Add(file);
                        if (file.EndsWith("txt"))
                        {
                            this.algos.ReadGraphFromTXTFile(file);
                        }
                        else if (file.EndsWith("csv"))
                        {
                            this.algos.ReadGraphFromCSVFile(file);
                        }
                        else
                            throw new Exception("This file type is not accepted.\nPlease select either a *.csv file or a *.txt file.");
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("Error: " + ex.Message);
                    }
                }
            }
        }
        private void Open_File(object sender, EventArgs e)
        {
            ToolStripButton open = sender as ToolStripButton;
            if (open.Name.Equals("open_txt"))
            {
                openFileDialog1.Filter = "txt files (*.txt)|*.txt";
                openFileDialog1.Multiselect = false;
            }
            else if (open.Name.Equals("open_csv"))
            {
                openFileDialog1.Filter = "csv files (*.csv)|*.csv";
                openFileDialog1.Multiselect = false;

            }
            DialogResult result = openFileDialog1.ShowDialog();
            if (result == DialogResult.OK)
            {
                try
                {
                    listBox1.Items.Add(openFileDialog1.FileNames[0]);
                    if (openFileDialog1.FileNames[0].EndsWith("txt"))
                    {
                        this.algos.ReadGraphFromTXTFile(openFileDialog1.FileNames[0]);
                    }
                    else if (openFileDialog1.FileNames[0].EndsWith("csv"))
                    {
                        this.algos.ReadGraphFromCSVFile(openFileDialog1.FileNames[0]);
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error: " + ex.Message);
                }
            }
        }
        private void Open_File_MenuStrip(object sender, EventArgs e)
        {
            ToolStripMenuItem open = sender as ToolStripMenuItem;
            if (open.Name.Equals("open_txt"))
            {
                openFileDialog1.Filter = "txt files (*.txt)|*.txt";
                openFileDialog1.Multiselect = false;
            }
            else if (open.Name.Equals("open_csv"))
            {
                openFileDialog1.Filter = "csv files (*.csv)|*.csv";
                openFileDialog1.Multiselect = false;

            }
            DialogResult result = openFileDialog1.ShowDialog();
            if (result == DialogResult.OK)
            {
                try
                {
                    listBox1.Items.Add(openFileDialog1.FileNames[0]);
                    if (openFileDialog1.FileNames[0].EndsWith("txt"))
                    {
                        this.algos.ReadGraphFromTXTFile(openFileDialog1.FileNames[0]);
                    }
                    else if (openFileDialog1.FileNames[0].EndsWith("csv"))
                    {
                        this.algos.ReadGraphFromCSVFile(openFileDialog1.FileNames[0]);
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error: " + ex.Message);
                }
            }
        }
        

        //Run Algorithms
        private void Run_Prim_Algorithm(object sender, EventArgs e)
        {
            this.algos.GetMST(listBox1.GetItemText(listBox1.SelectedItem));
            listBox2.Items.Add($"MST: {listBox1.GetItemText(listBox1.SelectedItem)}");
        }
        private void Run_Dijkstra_Algorithm(object sender, EventArgs e)
        {
            this.algos.Dijkstra(listBox1.GetItemText(listBox1.SelectedItem));
            listBox2.Items.Add($"Shortest Paths: {listBox1.GetItemText(listBox1.SelectedItem)}");
        }

        //Save Files
        private void Save_Graph_Result(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                var temp = listBox2.GetItemText(listBox2.SelectedItem).Trim();
                for (int i = 0; i < temp.Length; i++)
                {
                    temp = temp.Remove(0, temp.IndexOf(' ') + 1);
                }
                if (listBox2.GetItemText(listBox2.SelectedItem).Contains("Shortest Path"))
                    this.algos.WriteSSSPSolutionTo("shortest_path_result_" + temp, temp);
                else if (listBox2.GetItemText(listBox2.SelectedItem).Contains("MST"))
                    this.algos.WriteMSTSolutionTo("MST_result_" + temp, temp);

            }

        }
        

        //Delete Files
        private void delete_selected_graph(object sender, EventArgs e)
        {
            listBox1.Items.Remove(listBox1.GetItemText(listBox1.SelectedItem));
        }

        private void delete_all_graphs(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
        }
        */
    }
}