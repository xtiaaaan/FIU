namespace COP4226_Assignment3_NeatOffice
{
    public partial class Form1 : Form
    {
        private long result;
        public Form1()
        {
            InitializeComponent();
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
            calculator_textbox.Text += "÷";
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


        //---------------------------------------------------------------------------

        public static void insert_nonbinary_function(object sender, TextBox calculator_textbox)
        {
            ToolStripButton button = sender as ToolStripButton;
            switch (button.Name)
            {
                case ("LOG"):
                    calculator_textbox.Text = $"log({calculator_textbox.Text})";
                    break;
                case ("POW"):
                    calculator_textbox.Text = $"pow({calculator_textbox.Text})";
                    break;
                case ("SIN"):
                    calculator_textbox.Text = $"sin({calculator_textbox.Text})";
                    break;
                case ("COS"):
                    calculator_textbox.Text = $"cos({calculator_textbox.Text})";
                    break;
                case ("TAN"):
                    calculator_textbox.Text = $"tan({calculator_textbox.Text})";
                    break;
                case ("delete"):
                    calculator_textbox.Text = calculator_textbox.Text.Remove(calculator_textbox.Text.Length - 1, 1);
                    if (calculator_textbox.Text.Length == 0)
                        calculator_textbox.Text = 0.ToString();
                    break;
            }
        }
    }
}