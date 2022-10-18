using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace COP4226_Assignment3_NeatOffice
{
    public class CalculatorLogic
    {
        public CalculatorLogic()
        {
            this.calculatorHistory = new List<string>();
        }

        public void addNonBinary(object sender, TextBox calculatorTextbox)
        {
            ToolStripButton button = sender as ToolStripButton;
            switch (button.Name)
            {
                case ("LOG"):
                    calculatorTextbox.Text = $"LOG({calculatorTextbox.Text})";
                    break;
                case ("POW"):
                    calculatorTextbox.Text = $"POW({calculatorTextbox.Text})";
                    break;
                case ("SIN"):
                    calculatorTextbox.Text = $"SIN({calculatorTextbox.Text})";
                    break;
                case ("COS"):
                    calculatorTextbox.Text = $"COS({calculatorTextbox.Text})";
                    break;
                case ("TAN"):
                    calculatorTextbox.Text = $"TAN({calculatorTextbox.Text})";
                    break;
                case ("ERASE"):
                    if (calculatorTextbox.Text.Length > 1)
                        calculatorTextbox.Text = calculatorTextbox.Text.Remove(calculatorTextbox.Text.Length - 1, 1);
                    else
                        calculatorTextbox.Text = 0.ToString();
                    break;
            }
        }

        public void addOperation(object sender, TextBox calculatorTextbox)
        {
            if(calculatorTextbox.Text == "NaN" || calculatorTextbox.Text == "∞")
                calculatorTextbox.Clear();

            Button button = sender as Button;
            switch (button.Name)
            {
                case "buttonSQRT":
                    calculatorTextbox.Text = $"√({calculatorTextbox.Text})";
                    break;
                case "buttonFraction":
                    calculatorTextbox.Text = $"1/({calculatorTextbox.Text})";
                    break;
                case "buttonSquare":
                    calculatorTextbox.Text = $"POW({calculatorTextbox.Text})";
                    break;
                case "buttonErase":
                    if (calculatorTextbox.Text.Length > 1)
                        calculatorTextbox.Text = calculatorTextbox.Text.Remove(calculatorTextbox.Text.Length - 1, 1);
                    else
                        calculatorTextbox.Text = 0.ToString();
                    break;
                case "positiveNegative":
                    if (calculatorTextbox.Text.Substring(0, 1) == "-")
                        calculatorTextbox.Text = calculatorTextbox.Text.Remove(0, 1);
                    else
                        calculatorTextbox.Text = $"-{calculatorTextbox.Text}";
                    break;
                default:
                    calculatorTextbox.Text += button.Text;
                    break;
            }
        }

        public static void specialOperations(ref string calculatorContents, ref string operatorValue, ref string op, ref TextBox calculatorTextbox)
        {
            for(int i = 0; i < calculatorTextbox.Text.Length; i++)
            {
                char c = calculatorTextbox.Text[i];
                if(!Char.IsDigit(c) && op.Length < 3)
                {
                    switch (c)
                    {
                        case '√':
                        case 'S':
                        case 'C':
                        case 'T':
                        case 'L':
                        case 'P':
                            for (int j = i + 1; j < calculatorTextbox.Text.Length; j++)
                            {
                                op = calculatorTextbox.Text.Substring(i, j);
                                if (calculatorTextbox.Text[j] == '(')
                                    break;
                            }
                            break;
                    }
                }
                if (Char.IsDigit(c))
                    operatorValue += c;
            }
        }

        public String calculateResult(object sender, TextBox calculatorTextbox, String calculatorContents)
        {
            Button button = sender as Button;
            var v = new object();
            calculatorContents = "";
            String operatorValue = "";
            String op = "";
            try
            {
                CalculatorLogic.specialOperations(ref calculatorContents, ref operatorValue, ref op, ref calculatorTextbox);
                if (op.Equals("√"))
                    calculatorContents += Math.Sqrt(Double.Parse(operatorValue));
                else if (op.Equals("COS"))
                    calculatorContents += Math.Cos(Double.Parse(operatorValue));
                else if (op.Equals("SIN"))
                    calculatorContents += Math.Sin(Double.Parse(operatorValue));
                else if (op.Equals("TAN"))
                    calculatorContents += Math.Tan(Double.Parse(operatorValue));
                else if (op.Equals("LOG"))
                    calculatorContents += Math.Log(Double.Parse(operatorValue));
                else if (op.Equals("POW"))
                    calculatorContents += Math.Pow(Double.Parse(operatorValue), 2);
                else
                    calculatorContents = calculatorTextbox.Text;
                v = new DataTable().Compute(calculatorContents, "");

                calculatorHistory.Add(calculatorTextbox.Text + "=" + v.ToString());
                return v.ToString();
            }
            catch (Exception err)
            {
                return "NaN";
                v = "NaN";
            }
        }

        public List<String> calculatorHistory;
    }
}
