package com.bailiangjin.utilslibrary.constant.enums;

/**
 * 使用接口组织枚举
 * 
 * @author blj
 * 
 */
public interface EnumInterFace
{
	enum Coffee implements EnumInterFace
	{
		BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
	}

	enum Visiable implements EnumInterFace
	{
		VISIABLE, GONE, INVISIABLE
	}

	enum Dessert implements EnumInterFace
	{
		FRUIT, CAKE, GELATO
	}

}
