// Algorithms.cpp : 定义控制台应用程序的入口点。
//
#include "stdafx.h"
#include <iostream>

using namespace std;

void Shell_Sort(int list[], int l);
void Sort_N(int list[], int l, int step);
void Insert_N(int list[], int pointer, int temp, int step);
void Insert_Sort(int list[], int l);
void Insert(int list[], int pointer, int temp);

int _tmain(int argc, _TCHAR* argv[])
{
	int list[] = {1,7,23,77,3,4,5,6,2,4,12,4,54,12,9};
	int l = sizeof(list) / sizeof(list[0]);
	Shell_Sort(list, l);
	for (int i = 0; i < sizeof(list) / sizeof(list[0]); i++)
	{
		cout << list[i] << " ";
	}
	system("pause");
	return 0;
}

void Shell_Sort(int list[],int l)
{
	cout << l << endl;
	if (l <= 5){
		Insert_Sort(list,l);
	}
	Sort_N(list, l, 5);
	Sort_N(list, l, 3);
	Insert_Sort(list, l);
}

void Sort_N(int list[], int l , int step)
{
	int pointer = 5;
	int temp = 0;
	while (pointer < l)
	{
		while (temp < pointer)
		{
			if (list[pointer] < list[temp])
			{
				Insert_N(list, pointer, temp, step);
				break;
			}
			temp += step;
		}
		pointer++;
		temp = pointer % 5;
	}
}

void Insert_N(int list[], int pointer, int temp , int step)
{
	if (pointer < temp)
	{
		return;
	}
	int tempdata = list[pointer];
	for (int i = pointer; i > temp; i = i - step)
	{
		list[i] = list[i - step];
	}
	list[temp] = tempdata;
}

void Insert_Sort(int list[],int l)
{
	int pointer = 1;
	int temp = 0;
	while (pointer < l)
	{
		while (temp < pointer)
		{
			if (list[pointer] < list[temp])
			{
				Insert(list, pointer,temp);
				break;
			}
			temp++;
		}
		temp = 0;
		pointer++;
	}
}

void Insert(int list[], int pointer, int temp)
{
	if (pointer < temp)
	{
		return;
	}
	int tempdata = list[pointer];
	for (int i = pointer ; i > temp; i --)
	{
		list[i] = list[i - 1];
	}
	list[temp] = tempdata;
}
