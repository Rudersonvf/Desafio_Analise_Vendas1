package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {

	public static void main(String[] args) {

		final int year = 2016;

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Sale> sales = new ArrayList<>();

		System.out.print("Entre com o caminho do arquivo: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String lines = br.readLine();
			while (lines != null) {
				String[] fields = lines.split(",");
				sales.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2],
						Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
				lines = br.readLine();
			}

			Comparator<Sale> comp = (s1, s2) -> s1.averagePrice().compareTo(s2.averagePrice());

			List<Sale> firstSales = sales.stream()
					.filter(p -> p.getYear() <= year)
					.sorted(comp.reversed()).limit(5)
					.collect(Collectors.toList());

			System.out.printf("Cinco primeiras vendas de %d de maior preço médio\n", year);
			firstSales.forEach(System.out::println);

			double loganTotalValue = sales.stream()
					.filter(p -> p.getSeller().equals("Logan"))
					.filter(p -> p.getMonth().equals(1) || p.getMonth().equals(7))
					.map(p -> p.getTotal())
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println();
			System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7: " + String.format("%.2f", loganTotalValue));

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		sc.close();
	}

}
