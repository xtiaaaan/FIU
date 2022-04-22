/*
** Christian Angus
** FIU - 6197873
** Assignment 1
** Edge Detection
*/

#include <stdio.h>                          /* Sobel.c */
#include <math.h>

int pic[256][256];
int outpicx[256][256];
int outpicy[256][256];
int maskx[3][3] = {{-1,0,1},{-2,0,2},{-1,0,1}};
int masky[3][3] = {{1,2,1},{0,0,0},{-1,-2,-1}};
double ival[256][256],maxival, maxoutpicx, maxoutpicy;

main(argc,argv)
int argc;
char **argv;
{
    int i,j,p,q,mr,sum1,sum2;
    double lothreshold, hithreshold;
    FILE *fgradient, *flowthreshold, *fhighthreshold, *fxgradient, *fygradient, *finput, *fopen();
    char *foobar;

    // input file
    argc--; argv++;
    foobar = *argv;
    finput=fopen(foobar,"rb");

	// high threshold
	argc--; argv++;
	foobar = *argv;
	hithreshold = atoi(foobar);

	// low threshold
    argc--; argv++;
	foobar = *argv;
	lothreshold = atoi(foobar);

	// five output files
	fgradient = fopen("gradient.pgm", "wb");
	flowthreshold = fopen("lowThreshold.pgm", "wb");
	fhighthreshold = fopen("highThreshold.pgm", "wb");
	fxgradient = fopen("xGradient.pgm", "wb");
	fygradient = fopen("yGradient.pgm", "wb");

	// bypass file header
	for(i = 0; i < 15; i++)
        getc(finput);


    for (i=0;i<256;i++){
        for (j=0;j<256;j++){
            pic[i][j]  =  getc (finput);
            pic[i][j]  &= 0377;
        }
    }

    mr = 1;
    for (i=mr;i<256-mr;i++){
        for (j=mr;j<256-mr;j++){
            sum1 = 0;
            sum2 = 0;
            for (p=-mr;p<=mr;p++){
                for (q=-mr;q<=mr;q++){
                    sum1 += pic[i+p][j+q] * maskx[p+mr][q+mr];
                    sum2 += pic[i+p][j+q] * masky[p+mr][q+mr];
                }
            }
            outpicx[i][j] = sum1;
            outpicy[i][j] = sum2;
        }
    }

    maxival = 0;
    maxoutpicx = 0;
    maxoutpicy = 0;
    for (i=mr;i<256-mr;i++){
        for (j=mr;j<256-mr;j++){
            ival[i][j]=sqrt((double)((outpicx[i][j]*outpicx[i][j]) +
                                  (outpicy[i][j]*outpicy[i][j])));
            if (ival[i][j] > maxival)
                maxival = ival[i][j];

            if (outpicx[i][j] > maxoutpicx)
                maxoutpicx = outpicx[i][j];

            if (outpicy[i][j] > maxoutpicy)
                maxoutpicy = outpicy[i][j];
        }
    }

    // output file header
    fprintf(fgradient, "P5\n256 256\n255\n");
    fprintf(fxgradient, "P5\n256 256\n255\n");
    fprintf(fygradient, "P5\n256 256\n255\n");

    for (i=0;i<256;i++){
        for (j=0;j<256;j++){
            ival[i][j] = (ival[i][j] / maxival) * 255;
            fprintf(fgradient,"%c",(char)((int)(ival[i][j])));

            outpicx[i][j] = (outpicx[i][j] / maxoutpicx) * 255;
            fprintf(fxgradient,"%c",(char)((int)(outpicx[i][j])));

            outpicy[i][j] = (outpicy[i][j] / maxoutpicy) * 255;
            fprintf(fygradient,"%c",(char)((int)(outpicy[i][j])));
        }
      }

    // file headers
    fprintf(flowthreshold, "P5\n256 256\n255\n");
    fprintf(fhighthreshold, "P5\n256 256\n255\n");

    for(i=0; i<256; i++){
        for(j=0; j<256; j++){
            fprintf(flowthreshold, "%c", (ival[i][j] > lothreshold) ? 255 : 0);
            fprintf(fhighthreshold, "%c", (ival[i][j] > hithreshold) ? 255 : 0);
          }
        }

}
