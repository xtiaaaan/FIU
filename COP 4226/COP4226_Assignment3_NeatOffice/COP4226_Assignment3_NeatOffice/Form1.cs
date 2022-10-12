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

            textBox3.Text = "";
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            textBox3.Text += "";
        }

        //Digit 0-9 and "." decimal buttons
        private void digit1_Click(object sender, EventArgs e)
        {
            textBox3.Text += "1";
        }

        private void digit2_Click(object sender, EventArgs e)
        {
            textBox3.Text += "2";
        }

        private void digit3_Click(object sender, EventArgs e)
        {
            textBox3.Text += "3";
        }

        private void digit4_Click(object sender, EventArgs e)
        {
            textBox3.Text += "4";
        }

        private void digit5_Click(object sender, EventArgs e)
        {
            textBox3.Text += "5";
        }

        private void digit6_Click(object sender, EventArgs e)
        {
            textBox3.Text += "6";
        }

        private void digit7_Click(object sender, EventArgs e)
        {
            textBox3.Text += "7";
        }

        private void digit8_Click(object sender, EventArgs e)
        {
            textBox3.Text += "8";
        }

        private void digit9_Click(object sender, EventArgs e)
        {
            textBox3.Text += "9";
        }

        private void digit0_Click(object sender, EventArgs e)
        {
            textBox3.Text += "0";
        }

        private void decimalPoint_Click(object sender, EventArgs e)
        {
            textBox3.Text += ".";
        }


        // + - x / Operation buttons
        private void plus_Click(object sender, EventArgs e)
        {
            textBox3.Text += "+";
        }

        private void minus_Click(object sender, EventArgs e)
        {
            textBox3.Text += "-";
        }

        private void multiply_Click(object sender, EventArgs e)
        {
            //Might need to switch to asterisk
            textBox3.Text += "x";
        }

        private void divide_Click(object sender, EventArgs e)
        {
            textBox3.Text += "÷";
        }
        

    }
}