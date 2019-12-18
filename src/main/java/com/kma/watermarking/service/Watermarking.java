package com.kma.watermarking.service;

import com.kma.watermarking.model.StrObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.ArrayList;

@Service
public class Watermarking {
  Character[] V = new Character[] {'a', 'i', 'u', 'e', 'o'}; // nguyen am
  Character[] C = new Character[] {'b', 'e', 'd', 'f', 'g', 'h', 'k', 'l', 'n', 'p', 'q', 'r', 'w', 'z', 't', 'v'}; // phu am
  Character[] P = new Character[] {'\\', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '|', '\'', '?', '/'}; // ki tu dac biet
  String[] M = new String[] {"ten", "so_chung_minh"}; // m thuoc tinh gia tri cao
  String[] N = new String[] {"tuoi", "dia_chi"}; // n thuoc tinh gia tri thap
  @Autowired private ConNguoiService conNguoiService;

  public int checkV(char charactor) {
    String c = "";
    int valueASCII = 0;
    for (int i = 0; i < V.length; i++) {
      if (charactor == V[i]) {
        valueASCII = charactor; // convert ASCII
        return valueASCII;
      }
    }
    return 0;
  }

  public int checkC(char charactor) {
    String c = "";
    int valueASCII = 0;
    for (int i = 0; i < C.length; i++) {
      if (charactor == C[i]) {
        valueASCII = charactor; // convert ASCII
        return valueASCII;
      }
    }
    return 0;
  }

  public int checkP(char charactor) {
    String p = "";
    int valueASCII = 0;
    for (int i = 0; i < P.length; i++) {
      if (charactor == P[i]) {
        valueASCII = charactor; // convert ASCII
        return valueASCII;
      }
    }
    return 0;
  }

  public StrObject sumASCIIInString(String str) {

    char[] characters = str.toCharArray();
    int sumV = 0, sumC = 0, sumP = 0;
    int v = 0, c = 0, p = 0;
    for (int i = 0; i < characters.length; i++) {
      v = checkV(characters[i]);
      c = checkC(characters[i]);
      p = checkP(characters[i]);
      if (v != 0) sumV += v;
      else if (c != 0) sumC += c;
      else if (p != 0) ;
      sumP += p;
    }
    StrObject strObject = new StrObject(sumV, sumC, sumP);
    return strObject;
  }

  public int sumASCII(String str) {
    char[] characters = str.toCharArray();
    int sum = 0;
    for (int i = 0; i < characters.length; i++) {
      sum += characters[i];
    }
    return sum;
  }

  public void nhungThuyVan() {
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    data = conNguoiService.getData();
    int V_H = 0, C_H = 0, P_H = 0;
    int n = 2, m = 2;
    int w = 4; // so bo
    int[][] D = new int[n][4];
    double[][] N = new double[n][4];
    double[][] N_T = new double[4][n];
    double[][] W = new double[4][4];
    int K = 111;

    ArrayList<Integer> V_L_n = new ArrayList();
    ArrayList<Integer> C_L_n = new ArrayList();
    ArrayList<Integer> P_L_n = new ArrayList();
    ArrayList<Integer> A_L_n = new ArrayList();
    StrObject strObject = new StrObject();
    for (int i = 0; i < w; i++) { // tinh tong cac ma ASCII trong cac thuoc tinh gia tri cao
      for (int j = 0; j < m; j++) {
        strObject = sumASCIIInString(data.get(i).get(j));
        V_H += strObject.getSumASCIIV();
        C_H += strObject.getSumASCIIC();
        P_H += strObject.getSumASCIIP();
      }
    }
    for (int j = 0; j < n; j++) {
      int V_L_j = 0, C_L_j = 0, P_L_j = 0, A_L_j = 0;
      for (int i = 0; i < w; i++) {
        StrObject strObject1 = new StrObject();
        strObject = sumASCIIInString(data.get(i).get(j + 2));
        V_L_j += strObject.getSumASCIIP();
        C_L_j += strObject.getSumASCIIC();
        P_L_j += strObject.getSumASCIIP();
        A_L_j += A_L_j + V_L_j + C_L_j + P_L_j;
        V_L_n.add(V_L_j);
        C_L_n.add(C_L_j);
        P_L_n.add(P_L_j);
        A_L_n.add(A_L_j);
      }
    }

    // xay dung ma tran D
    for (int i = 0; i < n; i++) {
      D[i][0] = V_L_n.get(i) + V_H;
      D[i][1] = C_L_n.get(i) + C_H;
      D[i][2] = P_L_n.get(i) + P_H;
      D[i][3] = A_L_n.get(i);
    }

    // CHuan hoa ma tran
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 4; j++) {
        N[i][j] =
            (D[i][j]
                / Math.sqrt(
                    Math.pow(D[i][0], 2)
                        + Math.pow(D[i][1], 2)
                        + Math.pow(D[i][2], 2)
                        + Math.pow(D[i][3], 2)));
      }
    }

    // Chuyen vi N
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 4; j++) {
        N_T[j][i] = N[i][j];
      }
    }
    // nhan ma tran => W
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        W[i][j] = N_T[i][0] * N[0][j] + N_T[i][1] * N[1][j];
      }
    }
    // in W
    System.out.println("\n\nGia tri thuy van:");
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < 2; j++) {
        System.out.println(W[i][j] + " ");
      }
    // bam
      System.out.println("\n\nKi tu sinh:");
    for (int i = 0; i < 4; i++) {
      MD5 md5 = new MD5();
      double e = W[i][i] + K;
      String result = DigestUtils.md5Hex(e + "");
      int sumASCII = sumASCII(result);
      while (sumASCII >= 224) {
        int a = sumASCII / 224;
        sumASCII = sumASCII - a * 224;
      }
      sumASCII += 32;
      char c = (char) sumASCII;
      System.out.println(c);
    }
  }
}
