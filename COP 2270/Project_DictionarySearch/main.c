#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define WORDSIZE 99
#define MAXDICTWORDS 1000

void countAlphabets(char passedString[], int alphaCount[26]);

int compareAlphabetCount(int dictWordCount[26], int userWordCount[26]);

int main()
{
    int countWords = 0;
    char dictionary[MAXDICTWORDS][WORDSIZE];
    FILE *filePtr;
    char word[WORDSIZE], userInputString[WORDSIZE], tempWord[WORDSIZE];
    int alphaCount[26], tempAlphaCount[26], k;

    if((filePtr = fopen("dictionary.txt", "r")) == NULL){
        printf("Failed to open dictionary file ‘dictionary.txt’\n");
        return 0;
    }

        while(!feof(filePtr)){
            fgets(word, WORDSIZE, filePtr);
                strcpy(dictionary[countWords], word);
            countWords++;
        }

    fclose(filePtr);

    while(1){
        printf("Enter the letters: ");
        scanf("%s", userInputString);
        if(strcmp(userInputString, "exit") == 0)
            return 0;

        countAlphabets(userInputString, alphaCount);

        //for (int i=0; i<26 ; i++)
            //printf("alphaCount[%d] = %d\n",i,alphaCount[i]);


        printf("%s:\n", userInputString);
        for(k = 0; k < countWords; k++){
            strcpy(tempWord, dictionary[k]);
            countAlphabets(tempWord, tempAlphaCount);

            //for (int i=0; i<26 ; i++)
                //printf("tempAlphaCount[%d] = %d\n",i,tempAlphaCount[i]);

            if(compareAlphabetCount(tempAlphaCount, alphaCount) == 0){
                printf("\t%s\n", tempWord);

            }
        }
    }

    return 0;
}

void countAlphabets(char passedString[], int alphaCount[26])
{
    int k;

    for(k = 0; k < 26; k++)
        alphaCount[k] = 0;

    for(k = 0; passedString[k] != '\0' && passedString[k] != '\t'; k++){
        if(passedString[k] >= 'a' && passedString[k] <= 'z'){
            alphaCount[passedString[k] - 'a']++;
        }
    }
}

int compareAlphabetCount(int dictWordCount[26], int userWordCount[26])
{
    int k;

    for(k = 0; k < 26; k++){
        if(userWordCount[k] >= dictWordCount[k])
            continue;
        else
            return 1;
    }


    return 0;
}
