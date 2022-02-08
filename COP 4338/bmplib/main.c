/* 
**                            CHRISTIAN ANGUS
**                                6197873
**  I certify that this program is written and programmed by me and me alone
**  
**  This program is designed to manipulate an image from a 24-bit uncompressed bmp file.
**  The program takes the following command-line option: "% bmptool [-f | -r | -l | -s scale| -v ] [-o output_file] [input_file]"
**
**  Where -s means to zcale the image by a scale factor of 2 or 3 as indicated on the command
**  line with a 2 or a 3, -r means to rotate the image by 90 degrees clockwise, -l means to
**  rotate the image by 90 degrees counter-clockwise, -v means to flip the image vertically,
**  -f means to flip image horizontally.
*/

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include "bmplib.h"

int mod = 0; // Global flag to check if photo is modified

/*
 * This method enlarges a 24-bit, uncompressed .bmp file
 * that has been read in using readFile()
 *
 * original - an array containing the original PIXELs, 3 bytes per each
 * rows     - the original number of rows
 * cols     - the original number of columns
 *
 * scale    - the multiplier applied to EACH OF the rows and columns, e.g.
 *           if scale=2, then 2* rows and 2*cols
 *
 * new      - the new array containing the PIXELs, allocated within
 * newrows  - the new number of rows (scale*rows)
 * newcols  - the new number of cols (scale*cols)
 */
int enlarge(PIXEL *original, int rows, int cols, int scale,
            PIXEL **new, int *newrows, int *newcols)
{
  if (rows <= 0 || cols <= 0)
  {
    return -1;
  }

  *newrows = scale * rows;
  *newcols = scale * cols;
  *new = (PIXEL *)malloc((*newrows) * (*newcols) * sizeof(PIXEL));

  for (int row = 0; row < rows; row++)
  {
    for (int i = 0; i < scale; i++)
    {
      for (int col = 0; col < cols; col++)
      {
        for (int j = 0; j < scale; j++)
        {
          PIXEL *o = original + row * cols + col;
          PIXEL *n = (*new) + row * cols * scale * scale + cols * scale * i + col * scale + j;
          *n = *o;
        }
      }
    }
  }

  mod = 1; // Flag photo as modified

  return 0;
}

/*
 * This method rotates a 24-bit, uncompressed .bmp file that has been read
 * in using readFile(). The rotation is expressed in degrees and can be
 * positive, negative, or 0 -- but it must be a multiple of 90 degrees
 *
 * original - an array containing the original PIXELs, 3 bytes per each
 * rows     - the number of rows
 * cols     - the number of columns
 * rotation - a positive or negative rotation,
 *
 * new      - the new array containing the PIXELs, allocated within
 * newrows  - the new number of rows
 * newcols  - the new number of cols
 */
int rotate(PIXEL *original, int rows, int cols, int rotation,
           PIXEL **new, int *newrows, int *newcols)
{
  *new = (PIXEL *)malloc(rows * cols * sizeof(PIXEL));

  if (rotation == 90)
  {
    *newrows = cols;
    *newcols = rows;
    for (int row = 0; row < rows; row++)
    {
      for (int col = 0; col < cols; col++)
      {
        PIXEL *o = ((original) + (row * cols) + col);
        PIXEL *n = (*new) + (cols - 1 - col) * rows + row;
        *n = *o;
      }
    }
  }
  else if (rotation == 270)
  {
    *newrows = cols;
    *newcols = rows;
    for (int row = 0; row < rows; row++)
    {
      for (int col = 0; col < cols; col++)
      {
        PIXEL *o = ((original) + (row * cols) + col);
        PIXEL *n = (*new) + (col * rows) + (rows - 1 - row);
        *n = *o;
      }
    }
  }

  mod = 1; // Flag photo as modified

  return 0;
}

/*
 * This method Vertically flips a 24-bit, uncompressed bmp file
 * that has been read in using readFile().
 *
 * original - an array containing the original PIXELs, 3 bytes per each
 * rows     - the number of rows
 * cols     - the number of columns
 *
 * new      - the new array containing the PIXELs, allocated within
 */

int verticalflip(PIXEL *original, PIXEL **new, int rows, int cols)
{
  if (rows <= 0 || cols <= 0)
  {
    return -1;
  }

  *new = (PIXEL *)malloc(rows * cols * sizeof(PIXEL));

  for (int row = 0; row < rows; row++)
  {
    for (int col = 0; col < cols; col++)
    {
      PIXEL *o = original + row * cols + col;
      PIXEL *n = (*new) + (rows - 1 - row) * cols + col;
      *n = *o;
    }
  }

  mod = 1; // Flag photo as modified

  return 0;
}

/*
 * This method horizontally flips a 24-bit, uncompressed bmp file
 * that has been read in using readFile().
 *
 * THIS IS GIVEN TO YOU SOLELY TO LOOK AT AS AN EXAMPLE
 * TRY TO UNDERSTAND HOW IT WORKS
 *
 * original - an array containing the original PIXELs, 3 bytes per each
 * rows     - the number of rows
 * cols     - the number of columns
 *
 * new      - the new array containing the PIXELs, allocated within
 */
int flip(PIXEL *original, PIXEL **new, int rows, int cols)
{
  int row, col;

  if ((rows <= 0) || (cols <= 0))
    return -1;

  *new = (PIXEL *)malloc(rows * cols * sizeof(PIXEL));

  for (row = 0; row < rows; row++)
    for (col = 0; col < cols; col++)
    {
      PIXEL *o = original + row * cols + col;
      PIXEL *n = (*new) + row * cols + (cols - 1 - col);
      *n = *o;
    }

  mod = 1; // Flag photo as modified

  return 0;
}

int main(int argc, char *argv[])
{

  extern char *optarg;
  extern int optind;

  int r, c, newrow, newcol;
  PIXEL *b, *nb;
  char *infile;
  char *outfile;
  int fflag = 0, rflag = 0, lflag = 0, sflag = 0, vflag = 0;
  int scale = 0, cwise = 0, ccwise = 0;

  static char usage[] = "Usage: bmptool [-f | -r | -l | -s scale| -v ] [-o output_file] [input_file]\n\n";

  outfile = NULL;
  infile = NULL;

  while ((c = getopt(argc, argv, "frls:vo:")) != -1)
  {
    switch (c)
    {
    case 'f':
      if (fflag == 1)
      {
        continue; // If multiple instances of argument is passed, 2nd command is ignored
      }
      else
      {
        fflag = 1;
        break;
      }
    case 'r':
      if (rflag == 1)
      {
        continue; // If multiple instances of argument is passed, 2nd command is ignored
      }
      else
      {
        rflag = 1;
        cwise = 90; // Rotates photo 90° (clockwise)
        break;
      }
    case 'l':
      if (lflag == 1)
      {
        continue; // If multiple instances of argument is passed, 2nd command is ignored
      }
      else
      {
        lflag = 1;
        ccwise = 270; // Rotates photo -90° or 270° (counter clockwise)
        break;
      }
    case 's':
      if (sflag == 1)
      {
        continue; // If multiple instances of argument is passed, 2nd command is ignored
      }
      else
      {
        sflag = 1;
        scale = atoi(optarg); // Takes in argument for -s as value for scale
        break;
      }
    case 'v':
      if (vflag == 1)
      {
        continue; // If multiple instances of argument is passed, 2nd command is ignored
      }
      else
      {
        vflag = 1;
        break;
      }
    case 'o':
      outfile = optarg; // Takes in argument for -o as outfile filename
      break;
    case '?':
      break;
    default:
      printf(usage);
    }
  }

  for (; optind < argc; optind++)
  {
    infile = argv[optind];
  }

  readFile(infile, &r, &c, &b);

  /*
  **  Pass through checked flags from command line to
  **  functions available for bmptool program
  **
  **  If the global variable mod is flagged, it'll pass
  **  the nb (modified photo) to the functions instead of
  **  b (original photo) to continuously apply modifications
  */
  if (sflag == 1)
  {
    if (mod == 1)
    {
      enlarge(nb, r, c, scale, &nb, &newrow, &newcol);
    }
    else
    {
      enlarge(b, r, c, scale, &nb, &newrow, &newcol);
    }
    r = newrow;
    c = newcol;
  }
  if (rflag == 1)
  {
    if (mod == 1)
    {
      rotate(nb, r, c, cwise, &nb, &newrow, &newcol);
    }
    else
    {
      rotate(b, r, c, cwise, &nb, &newrow, &newcol);
    }
    r = newrow;
    c = newcol;
  }
  if (lflag == 1)
  {
    if (mod == 1)
    {
      rotate(nb, r, c, ccwise, &nb, &newrow, &newcol);
    }
    else
    {
      rotate(b, r, c, ccwise, &nb, &newrow, &newcol);
    }
    r = newrow;
    c = newcol;
  }
  if (fflag == 1)
  {
    if (mod == 1)
    {
      flip(nb, &nb, r, c);
    }
    else
    {
      flip(b, &nb, r, c);
    }
  }
  if (vflag == 1)
  {
    if (mod == 1)
    {
      verticalflip(nb, &nb, r, c);
    }
    else
    {
      verticalflip(b, &nb, r, c);
    }
  }

  writeFile(outfile, r, c, nb);

  free(b);
  free(nb);
  return 0;
}
