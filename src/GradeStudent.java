import java.util.Scanner;

public class GradeStudent {

	public static void main(String[] args) {
		begin();
		report();
    }
	
	/*để hiển thị thông điệp chào mừng. */
	public static void begin() {
		System.out.println("This program reads exam/homework scores and reports your overall course grade");
	}
	
	public static void report() {
		/*đây là tổng điểm sinh viên đạt được của 3 môn tính theo thang điểm 100*/
		double overall_percentage = midterm() + finalTerm() + homeWork();
		System.out.print(overall_percentage);
		
		double minGrade = overall_percentage;
		double GPA;
		/*a. Với min grade >=85%: GPA=3.0;*/
		if (minGrade  >= 85) {
			GPA = 3.0;
		} /*b. min grade >=75% và min grade <85%: thì GPA = 2.0; */ 
		else if(minGrade >=75) {
			GPA = 2.0;
		}/*c. min grade >=60% và min grade <75%: thì GPA= 1.0;*/ 
		else if(minGrade >= 60) {
			GPA = 1.0;
		}/* d. min grade < 60%: thì GPA= 0.0.**/
		else {
			GPA = 0.0;
		}
		
		//in ra GPA
		System.out.println("Your grade will be at least:" + GPA);
 	}
	
	public static double midterm() {
		Scanner scanner = new Scanner(System.in);
		// tức là trọng số của điểm thi giữa kỳ, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100.
		System.out.println("Midterm:");
		int weight = 0;
		do {
			//in ra số vừa nhập khi vòng lặp dừng
			System.out.print("Weight (0-100)?");
			weight = Integer.parseInt(scanner.nextLine());	
		} while (weight > 100);//Kiểm tra nếu số nhập vượt quá 100 thì bắt buộc nhập cho đến khi đúng dùng lại
		
		//là điểm số mà người dùng đã đạt được
		System.out.print("Score earned?");
		int scoreEarned = Integer.parseInt(scanner.nextLine());
		//là điểm thi bạn có được tăng không, chọn 1 nếu có, chọn 2 nếu không
		System.out.print("Were scores shifted (1=yes, 2=no)");
		//là số điểm mà đã được tăng
		int shifted = Integer.parseInt(scanner.nextLine());
		System.out.print("shifted Amount = ");
		int shiftedAmount = 0;
		if (shifted == 1) {
			shiftedAmount = Integer.parseInt(scanner.nextLine());
		}
		if (shifted == 2) {
			shiftedAmount = 0;
		}
	
		//là tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm, điểm tối đa của total point là 100
		System.out.print("Total points = ");

		int totalPoint = scoreEarned + shiftedAmount;
		
		if (totalPoint > 100) {
			totalPoint = 100;
			System.out.println(totalPoint + "/ 100");
		} else {
			System.out.println(totalPoint + "/ 100");
		}
		
		//Là điểm số đã tính dựa trên trọng số. Ví dụ trong này sẽ là weighted score =  (100/100) * 35 = 35.0/35 . 35 là điểm số tính trên thang điểm 35. 
		double weightedScore = (((double)scoreEarned/100) * weight);
		System.out.println("Weighted score = " + weightedScore + "/" + " " + weight);
		return weightedScore;
	}
	
	/*Hàm Tính điểm cuối kì */
	public static double finalTerm() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		// tức là trọng số của điểm thi giữa kỳ, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100.
		System.out.println("Final:");
		int weight = 0;
		do {
			System.out.print("Weight (0-100)?");
			weight = Integer.parseInt(scanner.nextLine());	
		} while (weight > 100);
		
		//là điểm số mà người dùng đã đạt được
		System.out.print("Score earned?");
		int scoreEarned = Integer.parseInt(scanner.nextLine());
		//là điểm thi bạn có được tăng không, chọn 1 nếu có, chọn 2 nếu không
		System.out.print("Were scores shifted (1=yes, 2=no)");
		//là số điểm mà đã được tăng
		int shifted = Integer.parseInt(scanner.nextLine());
		System.out.print("shifted Amount = ");
		int shiftedAmount = 0;
		if (shifted == 1) {
			shiftedAmount = Integer.parseInt(scanner.nextLine());
		}
		
		if (shifted == 2) {
			shiftedAmount = 0;
		}
	
		//là tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm, điểm tối đa của total point là 100
		System.out.print("Total points = ");

		int totalPoint = scoreEarned + shiftedAmount;
		
		if (totalPoint > 100) {
			totalPoint = 100;
			System.out.println(totalPoint + "/ 100");
		} else {
			System.out.println(totalPoint + "/ 100");
		}
		
		//Là điểm số đã tính dựa trên trọng số. Ví dụ trong này sẽ là weighted score =  (100/100) * 35 = 35.0/35 . 35 là điểm số tính trên thang điểm 35. 
		double weightedScore = (((double)totalPoint/100) * weight);
		
		System.out.format("Weighted score = " + weightedScore + "/" + " " + weight);
		return weightedScore;
	}
	
	
	public static double homeWork() {
		Scanner scanner = new Scanner(System.in);
		int weight = 0;
		do {
			//in so weight tu khoang 0 den 100
			System.out.print("Weight (0-100)?");
			weight = Integer.parseInt(scanner.nextLine());	
		} while (weight > 100);//kiem tra so weight ko dc qua 100 neu sai nhap lai cho den khi dung moi ngung vong lap
		int asm = 0;
		int max = 0;
		int total_asm = 0;
		int total_max = 0;
		/*Nhập vào Số asigment đã làm*/
		System.out.print("Number of assignments:");
		int assignment = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < assignment; i++) {
			System.out.print("Assignment" +  " " + (i + 1)  + " "  + "score and max:");
			asm = scanner.nextInt();//là điểm số thực của sinh viên đạt được
			max = scanner.nextInt();//điểm tối đa của bài assignment 2. 
			
			/*Thực hiện tính tổng điểm các asm và tổng điểm tối đa*/
			total_asm = total_asm + asm;
			total_max = total_max + max;
		}
		/*là số lượng buổi học sinh viên đã đi học và được điểm danh. Điểm này có thể hiểu là tính điểm chuyên cần cho sinh viên.  */
		System.out.print("How many sections did you attend:");
		int session = scanner.nextInt();
		
        /*tối đa điểm tính cho phần chuyên cần.*/
		int attend = 30;
		
		/*Là tổng số điểm chuyên cần của sinh viên */
		int sectionPoints = session * 5;
		System.out.println("Section points:"+ " " + sectionPoints + " " + "/" + attend);

		/*Thực hiện phép tính lấy tổng điểm asm cộng với tổng điểm chuyên cần*/
		int total_points_asm = total_asm + sectionPoints;
		/*Thực hiện phép tính lấy tổng điểm tối đa max cộng với tối đa điểm tính cho phần chuyên cần*/
		int total_points_max = total_max + attend;
		 System.out.println("Total points:" + total_points_asm + "/" + " " + total_points_max);

		 /*Weighted-score: Là điểm số đã tính dựa trên trọng số*/
		 double weightedScore = ((double)total_points_asm / total_points_max) * weight;
		 /*in ra  Weighted_score*/
		 System.out.println("Weighted score:" + weightedScore + "/" + " " + weight);
		 return weightedScore;
	}


}
