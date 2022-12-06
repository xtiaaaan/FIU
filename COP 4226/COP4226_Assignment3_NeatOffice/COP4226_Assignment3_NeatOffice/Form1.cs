using System.Data;
using System.Drawing.Printing;
using System.Windows.Forms;

namespace COP4226_Assignment3_NeatOffice
{
    public partial class Form1 : Form
    {

        private string currentCalculation = "";
        private string[] xycalHistory;
        private string xyCurrentInput = "";
        private string xyNewHistoryLine = "";
        private bool xyPressed = false;
        private string xyPressedValue = "";
        GraphAlgorithms g;
        //private bool currentCalculationBool = false;
        //private double currentCalculationDouble = 0;

        public Form1()
        {
            InitializeComponent();
            g = new GraphAlgorithms(toolStripProgressBar1, toolStripStatusLabel3, statusStrip2);
        }
        private void Form1_Close(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void MainForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            DialogResult result = MessageBox.Show("You sure you wanna close Neat Office?", "App In Progress", MessageBoxButtons.YesNo);
            e.Cancel = (result == DialogResult.No);
        }

        #region Calculator

        private void change_Calculator_Font_Click(object sender, EventArgs e)
        {

            if (fontDialog1.ShowDialog() == DialogResult.OK)
            {
                textBox1.Font = fontDialog1.Font;
            }

        }

        private void change_Calculator_Color_Click(object sender, EventArgs e)
        {

            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                tableLayoutPanel1.BackColor = colorDialog1.Color;
            }

        }

        private void digit_Click(object sender, EventArgs e)
        {

            double xyPressedButtonDouble;
            bool numQuestion = double.TryParse(((Button)sender).Text, out xyPressedButtonDouble);

            if (xyPressed == true && numQuestion)
            {
                double xyPressedValueDouble;
                double.TryParse(xyPressedValue, out xyPressedValueDouble);


                xyCurrentInput += (Math.Pow(xyPressedValueDouble, xyPressedButtonDouble));
                xyNewHistoryLine += xyPressedValue + "^" + ((Button)sender).Text + " =";

                xyCurrentInput = cal(xyCurrentInput).ToString();

                xycalHistory[xycalHistory.Length - 2] = xyNewHistoryLine;
                xycalHistory[xycalHistory.Length - 1] = xyCurrentInput;

                textBox1.Lines = xycalHistory;
                xyPressed = false;
                return;
            }

            if (String.Compare(textBox1.Lines[textBox1.Lines.Length - 1], "0") == 0 && int.TryParse(((Button)sender).Text, out _))
            {
                var calHistory = (string[])textBox1.Lines.Clone();
                calHistory[calHistory.Length - 1] = ((Button)sender).Text;
                textBox1.Lines = calHistory;
            }
            else
            {
                textBox1.Text += ((Button)sender).Text;
            }
        }

        private void backspace_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]) || String.Compare(textBox1.Lines[textBox1.Lines.Length - 1], "0") == 0)
            {
                return;
            }

            var calHistory = (string[])textBox1.Lines.Clone();

            var temp = textBox1.Lines[textBox1.Lines.Length - 1].Remove(textBox1.Lines[textBox1.Lines.Length - 1].Length - 1, 1);
            calHistory[calHistory.Length - 1] = temp;
            textBox1.Lines = calHistory;
        }

        private void squareRoot_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();
            string currentInput = calHistory[calHistory.Length - 3];

            string[] textSplit = calHistory[calHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            string newHistoryLine = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            currentInput += (Math.Pow(Double.Parse((cal(textSplit[index])).ToString()), 0.5)).ToString();
            newHistoryLine += "sqr(" + textSplit[index].Trim() + ") =";

            currentInput = cal(currentInput).ToString();

            calHistory[calHistory.Length - 2] = newHistoryLine;
            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private void square_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();
            string currentInput = calHistory[calHistory.Length - 3];

            string[] textSplit = calHistory[calHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            string newHistoryLine = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            currentInput += (Math.Pow(Double.Parse((cal(textSplit[index])).ToString()), 2)).ToString();
            newHistoryLine += "sqr(" + textSplit[index].Trim() + ") =";

            currentInput = cal(currentInput).ToString();

            calHistory[calHistory.Length - 2] = newHistoryLine;
            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private void divideOneBy_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]) || String.Compare(textBox1.Lines[textBox1.Lines.Length - 1], "0") == 0)
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();
            string currentInput = calHistory[calHistory.Length - 3];

            string[] textSplit = calHistory[calHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            string newHistoryLine = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            currentInput += cal("1/" + textSplit[index]);
            newHistoryLine += "1/" + textSplit[index] + " =";

            currentInput = cal(currentInput).ToString();

            calHistory[calHistory.Length - 2] = newHistoryLine;
            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private void calculate_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]) || String.Compare(textBox1.Lines[textBox1.Lines.Length - 1], "0") == 0)
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();

            currentCalculation = cal(calHistory[calHistory.Length - 2]).ToString().Trim();
            calHistory[calHistory.Length - 1] = cal(calHistory[calHistory.Length - 2]).ToString().Trim();
            calHistory[calHistory.Length - 2] = calHistory[calHistory.Length - 2] + "=";

            textBox1.Lines = calHistory;

        }

        private void CE_Click(object sender, EventArgs e)
        {
            var calHistory = (string[])textBox1.Lines.Clone();

            calHistory[calHistory.Length - 1] = "0";

            textBox1.Lines = calHistory;
        }

        private void C_Click(object sender, EventArgs e)
        {
            var calHistory = (string[])textBox1.Lines.Clone();

            if (calHistory.Length < 2)
            {
                return;
            }

            int index = calHistory.Length - 2;

            for (int i = index; i < calHistory.Length - 1; i++)
            {
                calHistory[i] = calHistory[i + 1];
            }

            Array.Resize(ref calHistory, calHistory.Length - 1);

            //calHistory[calHistory.Length - 2] = "";

            textBox1.Lines = calHistory;
        }

        private void plusMinus_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]) || String.Compare(textBox1.Lines[textBox1.Lines.Length - 1], "0") == 0)
            {
                return;
            }

            var calHistory = (string[])textBox1.Lines.Clone();

            string currentInput = calHistory[calHistory.Length - 1];
            string[] textSplit = calHistory[calHistory.Length - 1].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 1].Trim().Substring(0, (calHistory[calHistory.Length - 1].Length - textSplit[index].Length)).Trim();

            currentInput += "-" + textSplit[index];

            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private void log_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();
            string currentInput = calHistory[calHistory.Length - 3];

            string[] textSplit = calHistory[calHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            string newHistoryLine = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            //currentInput += (Math.Pow(Double.Parse((cal(textSplit[index])).ToString()), 2)).ToString();
            currentInput += (Math.Log10(Double.Parse((cal(textSplit[index])).ToString()))).ToString();
            newHistoryLine += "log(" + textSplit[index].Trim() + ") =";

            currentInput = cal(currentInput).ToString();

            calHistory[calHistory.Length - 2] = newHistoryLine;
            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private void xy_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            xycalHistory = (string[])textBox1.Lines.Clone();
            xyCurrentInput = xycalHistory[xycalHistory.Length - 3];

            string[] textSplit = xycalHistory[xycalHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            xyCurrentInput = xycalHistory[xycalHistory.Length - 3].Trim().Substring(0, (xycalHistory[xycalHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            xyNewHistoryLine = xycalHistory[xycalHistory.Length - 3].Trim().Substring(0, (xycalHistory[xycalHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            xyPressedValue = (cal(textSplit[index])).ToString();

            xyPressed = true;
            //currentInput += (Math.Pow(Double.Parse((cal(textSplit[index])).ToString()), 2)).ToString();
            //currentInput += (Math.Log10(Double.Parse((cal(textSplit[index])).ToString()))).ToString();
            //newHistoryLine += "log(" + textSplit[index].Trim() + ") =";

            //currentInput = cal(currentInput).ToString();

            //calHistory[calHistory.Length - 2] = newHistoryLine;
            //calHistory[calHistory.Length - 1] = currentInput;

            //textBox1.Lines = calHistory;

        }

        private void clear_History_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            currentCalculation = "";
            textBox1.Text = "0";

        }

        private void save_file_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]) || String.Compare(textBox1.Lines[textBox1.Lines.Length - 1], "0") == 0)
            {
                return;
            }

            //SaveFileDialog SaveFileDialog1 = new SaveFileDialog();
            string documentDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            saveFileDialog1.InitialDirectory = documentDirectory;
            saveFileDialog1.RestoreDirectory = true;
            saveFileDialog1.FilterIndex = 1;
            saveFileDialog1.DefaultExt = "txt";
            saveFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

            //saveFileDialog1.ShowDialog();

            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if (saveFileDialog1.FileName != "")
                {
                    string fileName = saveFileDialog1.FileName;

                    File.WriteAllText(fileName, textBox1.Text);
                }
            }

        }

        private void open_file_Click(object sender, EventArgs e)
        {
            //if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]) || String.Compare(textBox1.Lines[textBox1.Lines.Length - 1], "0") == 0)
            //{
            //    return;
            //}

            //SaveFileDialog SaveFileDialog1 = new SaveFileDialog();
            string documentDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            openFileDialog1.InitialDirectory = documentDirectory;
            openFileDialog1.RestoreDirectory = true;
            openFileDialog1.FilterIndex = 1;
            openFileDialog1.DefaultExt = "txt";
            openFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

            //saveFileDialog1.ShowDialog();

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if (openFileDialog1.FileName != "")
                {
                    string fileName = openFileDialog1.FileName;

                    textBox1.Text = File.ReadAllText(openFileDialog1.FileName);

                }
            }

        }

        private void sin_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();
            string currentInput = calHistory[calHistory.Length - 3];

            string[] textSplit = calHistory[calHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            string newHistoryLine = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            //currentInput += (Math.Pow(Double.Parse((cal(textSplit[index])).ToString()), 2)).ToString();
            currentInput += (Math.Sin(Double.Parse((cal(textSplit[index])).ToString()))).ToString();
            newHistoryLine += "sin(" + textSplit[index].Trim() + ") =";

            currentInput = cal(currentInput).ToString();

            calHistory[calHistory.Length - 2] = newHistoryLine;
            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private void cos_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();
            string currentInput = calHistory[calHistory.Length - 3];

            string[] textSplit = calHistory[calHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            string newHistoryLine = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            //currentInput += (Math.Pow(Double.Parse((cal(textSplit[index])).ToString()), 2)).ToString();
            currentInput += (Math.Cos(Double.Parse((cal(textSplit[index])).ToString()))).ToString();
            newHistoryLine += "cos(" + textSplit[index].Trim() + ") =";

            currentInput = cal(currentInput).ToString();

            calHistory[calHistory.Length - 2] = newHistoryLine;
            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private void tan_Click(object sender, EventArgs e)
        {
            if (textBox1.Lines.Length == 0 || String.IsNullOrEmpty(textBox1.Lines[textBox1.Lines.Length - 1]))
            {
                return;
            }

            textBox1.Text += Environment.NewLine;
            textBox1.Text += Environment.NewLine;
            var calHistory = (string[])textBox1.Lines.Clone();
            string currentInput = calHistory[calHistory.Length - 3];

            string[] textSplit = calHistory[calHistory.Length - 3].Trim().Split(new Char[] { 'x', '÷', '+', '-' });
            int index = textSplit.Length - 1;

            currentInput = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();
            string newHistoryLine = calHistory[calHistory.Length - 3].Trim().Substring(0, (calHistory[calHistory.Length - 3].Length - textSplit[index].Length)).Trim();

            //currentInput += (Math.Pow(Double.Parse((cal(textSplit[index])).ToString()), 2)).ToString();
            currentInput += (Math.Tan(Double.Parse((cal(textSplit[index])).ToString()))).ToString();
            newHistoryLine += "tan(" + textSplit[index].Trim() + ") =";

            currentInput = cal(currentInput).ToString();

            calHistory[calHistory.Length - 2] = newHistoryLine;
            calHistory[calHistory.Length - 1] = currentInput;

            textBox1.Lines = calHistory;
        }

        private object cal(string text)
        {
            string formattedCalculation = text.ToString().Replace("x", "*").ToString().Replace("÷", "/").ToString();
            Console.WriteLine(formattedCalculation);

            DataTable dt = new DataTable();
            var v = new object();
            try
            {
                v = dt.Compute(formattedCalculation, "");
            }
            catch (Exception e)
            {
                v = "NaN";
            }

            return v;
        }

        #endregion

        #region DaysCounter

        private void change_DayCounter_Color_Click(object sender, EventArgs e)
        {

            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                splitContainer2.Panel2.BackColor = colorDialog1.Color;
            }

        }

        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            if (numericUpDown1.ContainsFocus)
            {
                decimal count = numericUpDown1.Value;
                if (count > 0)
                    toDate.Value = fromDate.Value.AddDays((double)count);
                else if (count < 0)
                    fromDate.Value = toDate.Value.AddDays((double)-count);
                else
                    toDate.Value = fromDate.Value;
            }
        }

        private void fromDate_ValueChanged(object sender, EventArgs e)
        {
            if (((DateTimePicker)sender).ContainsFocus)
            {
                DateTime to = toDate.Value;
                DateTime from = fromDate.Value;
                numericUpDown1.Value = to.Subtract(from).Days;
                numericUpDown1.Value = numericUpDown1.Value + (decimal)1;
            }
        }
        #endregion

        #region Graph

        private void change_Graph_Color_Click(object sender, EventArgs e)
        {

            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                splitContainer1.Panel2.BackColor = colorDialog1.Color;
            }

        }

        private void open_Txt_Graph_Click(object sender, EventArgs e)
        {

            string documentDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            openFileDialog1.InitialDirectory = documentDirectory;
            openFileDialog1.RestoreDirectory = true;
            //openFileDialog1.FilterIndex = 1;
            openFileDialog1.DefaultExt = "txt";
            openFileDialog1.Filter = "txt files (*.txt)|*.txt";

            //saveFileDialog1.ShowDialog();

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if (openFileDialog1.FileName != "")
                {
                    string fileName = openFileDialog1.FileName;

                    g.ReadGraphFromTXTFile(fileName);
                    listBox2.Items.Add(fileName);

                    //textBox1.Text = File.ReadAllText(openFileDialog1.FileName);

                }
            }

        }

        private void open_Csv_Graph_Click(object sender, EventArgs e)
        {

            string documentDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            openFileDialog1.InitialDirectory = documentDirectory;
            openFileDialog1.RestoreDirectory = true;
            //openFileDialog1.FilterIndex = 1;
            openFileDialog1.DefaultExt = "csv";
            openFileDialog1.Filter = "csv files (*.csv)|*.csv";

            //saveFileDialog1.ShowDialog();

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if (openFileDialog1.FileName != "")
                {
                    string fileName = openFileDialog1.FileName;

                    g.ReadGraphFromCSVFile(fileName);
                    listBox2.Items.Add(fileName);

                    //textBox1.Text = File.ReadAllText(openFileDialog1.FileName);

                }
            }

        }

        private void open_Multiple_Graph_Click(object sender, EventArgs e)
        {

            string documentDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            openFileDialog1.InitialDirectory = documentDirectory;
            openFileDialog1.RestoreDirectory = true;
            openFileDialog1.Multiselect = true;
            //openFileDialog1.FilterIndex = 1;
            //openFileDialog1.DefaultExt = "csv";
            openFileDialog1.Filter = "all supported(*.csv,*.txt)|*.csv;*.txt|csv files (*.csv)|*.csv|txt files (*.txt)|*.txt";

            //saveFileDialog1.ShowDialog();

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                if (openFileDialog1.FileNames.Length > 0)
                {

                    foreach (string item in openFileDialog1.FileNames)
                    {

                        if (String.Compare(Path.GetExtension(item), ".csv") == 0)
                        {
                            g.ReadGraphFromCSVFile(item);
                            listBox2.Items.Add(item);
                        }
                        else if (String.Compare(Path.GetExtension(item), ".txt") == 0)
                        {
                            g.ReadGraphFromTXTFile(item);
                            listBox2.Items.Add(item);
                        }

                    }

                }
            }

        }

        private void delete_Selected_Graph_Click(object sender, EventArgs e)
        {
            listBox2.Items.Remove(listBox2.SelectedItem);

        }

        private void delete_Selected_Graphs_Click(object sender, EventArgs e)
        {

            while (listBox2.Items.Count != 0)
            {
                listBox2.Items.RemoveAt(0);
            }

        }

        private void apply_Prims_Click(object sender, EventArgs e)
        {

            if (listBox2.SelectedItems.Count > 0 && listBox2.SelectedItems.Count < 2)
            {
                string temp = listBox2.SelectedItem.ToString();

                g.GetMST(temp);
                temp = "MST: " + temp;

                listBox1.Items.Add(temp);
            }

        }

        private void apply_Dijkstras_Click(object sender, EventArgs e)
        {

            if (listBox2.SelectedItems.Count > 0 && listBox2.SelectedItems.Count < 2)
            {
                string temp = listBox2.SelectedItem.ToString();

                g.Dijkstra(temp);
                temp = "Shortest Paths: " + temp;

                listBox1.Items.Add(temp);
            }

        }

        private void save_Graph_Results_Click(object sender, EventArgs e)
        {

            if (listBox1.SelectedItems.Count > 0 && listBox1.SelectedItems.Count < 2)
            {
                string documentDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

                saveFileDialog1.InitialDirectory = documentDirectory;
                saveFileDialog1.RestoreDirectory = true;
                saveFileDialog1.FilterIndex = 1;
                saveFileDialog1.DefaultExt = "txt";
                saveFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

                //saveFileDialog1.ShowDialog();

                if (saveFileDialog1.ShowDialog() == DialogResult.OK)
                {
                    if (saveFileDialog1.FileName != "")
                    {

                        string[] tempFile = listBox1.SelectedItem.ToString().Split(": ");

                        if (String.Compare(tempFile[0], "MST") == 0)
                        {
                            g.WriteMSTSolutionTo(saveFileDialog1.FileName, tempFile[1]);
                            listBox1.Items.Remove(listBox1.SelectedItem);
                        }
                        else if (String.Compare(tempFile[0], "Shortest Paths") == 0)
                        {
                            g.WriteSSSPSolutionTo(saveFileDialog1.FileName, tempFile[1]);
                            listBox1.Items.Remove(listBox1.SelectedItem);
                        }

                    }
                }
            }

        }

        #endregion

        private void Form1_Load(object sender, EventArgs e)
        {
            textBox1.Text = "0";
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            toolStripStatusLabel1.Text = "Good Day! Today is " + DateTime.Now.ToString();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            if (textBox1.Visible)
            {
                textBox1.SelectionStart = textBox1.Text.Length;
                textBox1.ScrollToCaret();
            }
        }
    }
}