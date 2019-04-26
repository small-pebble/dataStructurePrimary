package com.dyy.huffmantree.huffmancode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHuffmanCode {
	public static void main(String[] args) {
		/*String msg = "can you can a can as a can canner can a can";
		byte[] bytes = msg.getBytes();
		//进行哈夫曼编码
		byte[] b = huffmanCode(bytes);
		//使用赫弗曼编码进行解码
		byte[] newBytes = deCode(huffmanCodes,b);*/
		//用赫弗曼编码压缩文件
		/*String src = "C:/Users/11585/Documents/1.PPTX";
		String des = "C:/Users/11585/Documents/2.zip";
		try {
			huffmanZip(src,des);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//用赫弗曼编码解压文件
		String src = "C:/Users/11585/Documents/2.zip";
		String des = "C:/Users/11585/Documents/3.PPTX";

		try {
			huffmanUnZip(src, des);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 将指定文件解压到指定目录
	 */
	private static void huffmanUnZip(String src, String des) throws Exception {
		InputStream ins = new FileInputStream(src);
		ObjectInputStream ois = new ObjectInputStream(ins);
		//获得压缩后的字节数组
		byte[] b = (byte[]) ois.readObject();
		//获得赫弗曼编码
		Map<Byte,String> huffCodes = (Map<Byte, String>) ois.readObject();
		ois.close();
		ins.close();
		//根据赫弗曼编码进行解压
		byte[] deBytes = deCode(huffCodes,b);
		OutputStream outs = new FileOutputStream(des);
		outs.write(deBytes);
		outs.close();
	}

	/*
	 * 将指定文件压缩到指定目录
	 */
	private static void huffmanZip(String src, String des) throws IOException {
		InputStream ins = new FileInputStream(src);
		//byte数组存读入的字节
		byte[] b = new byte[ins.available()];
		ins.read(b);
		ins.close();
		//使用赫弗曼对读入字节编码
		byte[] codes = huffmanCode(b);
		//将byte数组和哈夫曼编码写到输出文件
		OutputStream outs = new FileOutputStream(des);
		ObjectOutputStream oos = new ObjectOutputStream(outs);
		oos.writeObject(codes);
		oos.writeObject(huffmanCodes);
		oos.close();
		outs.close();
	}

	//赫弗曼解压缩
	private static byte[] deCode(Map<Byte,String> huffmanCodes,byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		//将byte数组转为二进制字符串
		for(int i=0;i<bytes.length;i++){
			String binStr;
			if(i!=bytes.length-1){
				binStr = getBinStr(bytes[i]);
			}else{
				binStr = Integer.toBinaryString(bytes[i]);
			}
			sb.append(binStr);
		}
		//将二进制字符串切割为对应字符数组
		Map<String,Byte> deCodes = new HashMap();
		//临时存储解压后的字符
		List<Byte> deBytes = new ArrayList<Byte>();
		for(Map.Entry<Byte, String> entry:huffmanCodes.entrySet()){
			deCodes.put(entry.getValue(), entry.getKey());
		}
		for(int i=0;i<sb.length();){
			int count = 1;
			boolean flag = true;
			while(flag){
				String s = sb.substring(i,i+count);
				Byte key = deCodes.get(s);
				if(key==null){
					count++;
				}else{
					deBytes.add(key);
					flag = false;
				}
			}
			i += count;
		}
		byte[] newBytes = new byte[deBytes.size()];
		int index = 0;
		for(byte b:deBytes){
			newBytes[index++] = b;
		}
		return newBytes;
	}

	private static String getBinStr(byte b) {
		int temp = b;
		temp |= 256;
		String str = Integer.toBinaryString(temp);
		return str.substring(str.length()-8);
	}

	//进行赫弗曼压缩的方法
	private static byte[] huffmanCode(byte[] bytes) {
		//统计字符数组中，每个字符出现次数，并放入一个集合中（把byte数组转化为node集合）
		List<Node> nodes = getNodes(bytes);
		//创建一颗赫弗曼数
		Node tree = createHuffmanTree(nodes);
		//创建一个赫弗曼编码表
		Map<Byte,String> huffmanCodes = getHuffmanCodes(tree);
		//编码
		byte[] b = getCodes(bytes,huffmanCodes);
		return b;
	}

	/*
	 * 根据哈夫曼编码表生成哈夫曼编码的字节数组
	 */
	private static byte[] getCodes(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder sb = new StringBuilder();
		for(byte b:bytes){
			sb.append(huffmanCodes.get(b));
		}
		
		int len = (sb.length()+7)/8;
		byte[] b = new byte[len];
		int index = 0;
		for(int i=0;i<sb.length();i+=8){
			String str;
			if(i+8>sb.length()){
				str = sb.substring(i);
			}else{
				str = sb.substring(i,i+8);
			}
			byte byteCode = (byte)Integer.parseInt(str,2);
			b[index++] = byteCode;
		}
		return b;
	}


	//生成赫弗曼树的过程中，临时存储编码
	static StringBuilder sbTemp = new StringBuilder(); 
	//存储生成的赫弗曼编码
	static Map<Byte,String> huffmanCodes = new HashMap();
	/*
	 * 根据赫弗曼树获得赫弗曼编码表
	 */
	private static Map<Byte, String> getHuffmanCodes(Node tree) {
		if(tree==null){
			return null;
		}
		getHuffmanCode(tree.leftNode,"0",sbTemp);
		getHuffmanCode(tree.rightNode,"1",sbTemp);
		return huffmanCodes;
	}

	private static void getHuffmanCode(Node node, String code, StringBuilder sbTemp) {
		StringBuilder sb = new StringBuilder(sbTemp);
		sb.append(code);
		if(node.value==null){
			getHuffmanCode(node.leftNode,"0",sb);
			getHuffmanCode(node.rightNode, "1", sb);
		}else{
			huffmanCodes.put(node.value, sb.toString());
		}
	}

	/*
	 * 创建一个赫弗曼树
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		//排序
		Collections.sort(nodes);
		while(nodes.size()>1){
			Node left = nodes.get(nodes.size()-1);
			Node right = nodes.get(nodes.size()-2);
			Node newNode = new Node(null,left.weight+right.weight);
			newNode.leftNode = left;
			newNode.rightNode = right;
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(newNode);
			Collections.sort(nodes);
		}
		return nodes.get(0);
	}

	/*
	 * 把数组转为node集合
	 */
	private static List<Node> getNodes(byte[] bytes) {
		//创建一个存node的集合
		List<Node> nodes = new ArrayList();
		//统计node集合中每一种byte出现次数
		Map<Byte,Integer> counts = new HashMap();  
		//统计每一个byte出现的次数
		for(byte b:bytes){
			Integer count = counts.get(b);
			if(count==null){
				counts.put(b, 1);
			}else{
				counts.put(b, ++count);
			}
		}
		//将每个键值对转为node对象，存入nodes中
		for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
}
