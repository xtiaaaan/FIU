using System.Drawing.Printing;

namespace COP4226_Assignment3_NeatOffice
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            this.graphAlgo = new GraphAlgorithms(graphProgressBar, graphStatusLabel, graphStatusStrip);
            this.calculatorLogic = new CalculatorLogic();
        }

        private void calculateResultHandler(object sender, EventArgs e)
        {
            String result = calculatorLogic.calculateResult(sender, calculatorTextbox, this.calculatorContents);
            calculatorTextbox.Text = result;
            calculatorContents = result;
        }

        private void operatorHandler(object sender, EventArgs e)
        {
            calculatorLogic.addOperation(sender, calculatorTextbox);
        }

        private void operationHandling(object sender, EventArgs e)
        {
            calculatorLogic.addNonBinary(sender, calculatorTextbox);
        }

        private void digitHandler(object sender, EventArgs e)
        {
            if (calculatorTextbox.Text == "0" || calculatorTextbox.Text == "NaN" || calculatorTextbox.Text == "∞")
                calculatorTextbox.Clear();
            Button button = sender as Button;
            calculatorTextbox.Text += button.Text;
        }

        private void clearText(object sender, EventArgs e)
        {
            calculatorTextbox.Text = 0.ToString();
            this.calculatorContents = 0.ToString();
            calculatorLogic.calculatorHistory.Clear();
        }

        private void ceClick(object sender, EventArgs e)
        {
            calculatorTextbox.Text = 0.ToString();
            this.calculatorContents = calculatorTextbox.Text;
        }

        private void dateCalculator(object sender, EventArgs e)
        {
            if (((DateTimePicker)sender).ContainsFocus)
                dayCounter.Value = (toDatePicker.Value - fromDatePicker.Value).Days;
        }

        private void dateUpDownChange(object sender, EventArgs e)
        {
            if (dayCounter.ContainsFocus)
            {
                decimal count = dayCounter.Value;
                if (count > 0)
                    toDatePicker.Value = fromDatePicker.Value.AddDays((double)count);
                else if (count < 0)
                    fromDatePicker.Value = toDatePicker.Value.AddDays((double)count);
                else
                    toDatePicker.Value = fromDatePicker.Value;
            }
        }

        private void toolStripStatusTimer(object sender, EventArgs e)
        {
            toolStripStatusLabel.Text = $"Good Day! Today is {DateTime.Today.ToLongDateString()}. The time is {DateTime.Now.ToLongTimeString()}";
        }

        private void printHistory(object sender, EventArgs e)
        {
            PrintDialog printDialog = new PrintDialog();
            PrintDocument printDocument = new PrintDocument();
            printDialog.ShowDialog();
        }

        private void changeBackgroundColor(object sender, EventArgs e)
        {
            ToolStripMenuItem backgroundColorMenu = sender as ToolStripMenuItem;
            ColorDialog colorDialog = new ColorDialog();
            if(colorDialog.ShowDialog() == DialogResult.OK)
                switch (backgroundColorMenu.Name)
                {
                    case "calculatorBackground":
                        horizontalContainer.Panel1.BackColor = colorDialog.Color;
                        break;
                    case "dayCounterBackground":
                        horizontalContainer.Panel2.BackColor = colorDialog.Color;
                        break;
                    case "graphBackground":
                        verticalContainer.Panel2.BackColor = colorDialog.Color;
                        break;
                    case "backgroundColorMenu":
                        this.BackColor = colorDialog.Color;
                        break;
                }
        }

        private void changeCalculatorFont(object sender, EventArgs e)
        {
            FontDialog fontDialog = new FontDialog();
            if(fontDialog.ShowDialog() == DialogResult.OK)
                foreach(Control controlItem in tableLayoutPanel1.Controls)
                {
                    controlItem.Font = fontDialog.Font;
                }
        }

        private void openMultipleFiles(object sender, EventArgs e)
        {
            DialogResult result = openFileDialog1.ShowDialog();
            if(result == DialogResult.OK)
            {
                foreach(String file in openFileDialog1.FileNames)
                {
                    try
                    {
                        importedGraphsList.Items.Add(file);
                        if (file.EndsWith("txt"))
                        {
                            this.graphAlgo.ReadGraphFromTXTFile(file);
                        }
                        else if (file.EndsWith("csv"))
                        {
                            this.graphAlgo.ReadGraphFromCSVFile(file);
                        }
                        else
                            throw new Exception("This file type is not accepted.\nPlease select either a .csv or a .txt file.");
                    }
                    catch(Exception err)
                    {
                        MessageBox.Show("Error" + err.Message);
                    }
                }
            }
        }

        private void openFile(object sender, EventArgs e)
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
            if(result == DialogResult.OK)
            {
                try
                {
                    importedGraphsList.Items.Add(openFileDialog1.FileNames[0]);
                    if (openFileDialog1.FileNames[0].EndsWith("txt"))
                    {
                        this.graphAlgo.ReadGraphFromTXTFile(openFileDialog1.FileNames[0]);
                    }
                    else if (openFileDialog1.FileNames[0].EndsWith("csv"))
                    {
                        this.graphAlgo.ReadGraphFromCSVFile(openFileDialog1.FileNames[0]);
                    }
                }
                catch(Exception err)
                {
                    MessageBox.Show("Error: " + err.Message);
                }
            }
        }

        private void openFileMenuStrip(object sender, EventArgs e)
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
            if(result == DialogResult.OK)
            {
                try
                {
                    importedGraphsList.Items.Add(openFileDialog1.FileNames[0]);
                    if (openFileDialog1.FileNames[0].EndsWith("txt"))
                    {
                        this.graphAlgo.ReadGraphFromTXTFile(openFileDialog1.FileNames[0]);
                    }
                    else if (openFileDialog1.FileNames[0].EndsWith("csv"))
                    {
                        this.graphAlgo.ReadGraphFromCSVFile(openFileDialog1.FileNames[0]);
                    }
                }
                catch(Exception err)
                {
                    MessageBox.Show("Error: " + err.Message);
                }
            }
        }

        private void openCalculatorHistory(object sender, EventArgs e)
        {
            openFileDialog1.Filter = "txt files (*.txt)|*.txt";
            openFileDialog1.Multiselect = false;
            string[] lines = File.ReadAllLines(openFileDialog1.FileName);
            foreach (string line in lines)
            {
                calculatorLogic.calculatorHistory.Add(line);
            }
        }

        private void runPrim(object sender, EventArgs e)
        {
            this.graphAlgo.GetMST(importedGraphsList.GetItemText(importedGraphsList.SelectedItem));
            resultsList.Items.Add($"MST: {importedGraphsList.GetItemText(importedGraphsList.SelectedItem)}");
        }

        private void runDjikstras(object sender, EventArgs e)
        {
            this.graphAlgo.Dijkstra(importedGraphsList.GetItemText(importedGraphsList.SelectedItem));
            resultsList.Items.Add($"Shortest Paths: {importedGraphsList.GetItemText(importedGraphsList.SelectedItem)}");
        }

        private void saveGraphResults(object sender, EventArgs e)
        {
            if(saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                var temp = resultsList.GetItemText(resultsList.SelectedItem).Trim();
                for(int i = 0; i < temp.Length; i++)
                {
                    temp = temp.Remove(0, temp.IndexOf(' ') + 1);
                }
                if (resultsList.GetItemText(resultsList.SelectedItem).Contains("Shortest Path"))
                    this.graphAlgo.WriteSSSPSolutionTo("shortest_path_result_" + temp, temp);
                else if (resultsList.GetItemText(resultsList.SelectedItem).Contains("MST"))
                    this.graphAlgo.WriteMSTSolutionTo("MST_result_" + temp, temp);
            }
        }

        private void saveCalculator(object sender, EventArgs e)
        {
            if(saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                TextWriter tw = new StreamWriter(saveFileDialog1.FileName);
                foreach (String s in calculatorLogic.calculatorHistory)
                    tw.WriteLine(s);
                tw.Close();
            }
        }

        private void deleteSelectedGraph(object sender, EventArgs e)
        {
            importedGraphsList.Items.Remove(importedGraphsList.GetItemText(importedGraphsList.SelectedItem));
        }

        private void deleteAllGraphs(object sender, EventArgs e)
        {
            importedGraphsList.Items.Clear();
        }

        private void exitApplication(object sender, EventArgs e)
        {
            this.Close();
        }
        
        private String calculatorContents;
        private GraphAlgorithms graphAlgo;
        private CalculatorLogic calculatorLogic;
    }
}