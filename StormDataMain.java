package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This is the main class for the storm data
 * @author Zachary Boster
 * 
 */
public class StormDataMain {
	
	public static <T> void main(String[] args) throws IOException, EmptySetException {
		
		Scanner Scan = new Scanner(System.in);
		String FileName = "";
		
		while (!FileName.equalsIgnoreCase("q")) {
			System.out.print("Enter data file name or q to quit: ");
			FileName = Scan.nextLine();
			File file = new File(FileName);
			if (file.isFile() && file.exists()) { //check that file exists if users gives bad input
				System.out.print("How would you like the data to be sorted? Event_Id, State, Year, or None: ");
				String sortChoice = Scan.nextLine();
				System.out.println("Calculating...");
				BufferedReader br = new BufferedReader(new FileReader(file));
				String Line = br.readLine();
				DoubleLinkedList<T> LinkedSet = new DoubleLinkedList<T>();
				DoubleLinkedList<T> EventIds = new DoubleLinkedList<T>();
				DoubleLinkedList<T> SortedLinkedSet = new DoubleLinkedList<T>();
				
				//while loop stores data from the csv file into a linked list
				while (Line != null) { 
					 String[] tokens = Line.split(",", 51);
					 StormData<T> storm = new StormData<T>(tokens);
					 if (!EventIds.Contains((T) storm.getEventId())) {
						 LinkedSet.addLast((T) storm);
					 }
					 EventIds.addFirst((T) storm.getEventId());
					 Line = br.readLine();
				}
				
				//uses insertion sort to sort the elements in the Linked Set by Event_Id
				if (sortChoice.equalsIgnoreCase("event_id")) {
					for(int  i = 1;  i < LinkedSet.size(); i++) {
						String[] token = LinkedSet.get(i).toString().split(",",51);
						for( int j = i; j > 0; j--) {
							String[] token2 = LinkedSet.get(j).toString().split(",",51);
							if (Integer.parseInt(token[7]) > Integer.parseInt(token2[7])) {
								SortedLinkedSet.insert(j-1, ((T) token));
								break;
							}
						}
					}
				//uses insertion sort to sort the elements in the Linked Set by State
				} else if (sortChoice.equalsIgnoreCase("state")) {
					for(int  i = 1;  i < LinkedSet.size(); i++) {
						String[] token = LinkedSet.get(i).toString().split(",",51);
						for( int j = i; j > 0; j--) {
							String[] token2 = LinkedSet.get(j).toString().split(",",51);
							if ((int)(token[8].charAt(0)) > (int)(token2[8].charAt(0))) {
								SortedLinkedSet.insert(j-1, ((T) token));
								break;
							}
						}
					}
					//uses insertion sort to sort the elements in the Linked Set by Year	
				} else if (sortChoice.equalsIgnoreCase("year")) {
					for(int  i = 1;  i < LinkedSet.size(); i++) {
						String[] token = LinkedSet.get(i).toString().split(",",51);
						for( int j = i; j > 0; j--) {
							String[] token2 = LinkedSet.get(j).toString().split(",",51);
							if (Integer.parseInt(token[10]) > Integer.parseInt(token2[10])) {
								SortedLinkedSet.insert(j-1, ((T) token));
								break;
							}
						}
					}
				}

				String manipulationLoop = "";
				while (!manipulationLoop.equalsIgnoreCase("q")) {
					System.out.print("Enter (o)utput, (sum)mary, (f)ind, (d)elete, (s)ort,  or (q)uit:");
					manipulationLoop = Scan.nextLine();
					
					//prints the output of the Linked Set
					if (manipulationLoop.equalsIgnoreCase("o")) {
						System.out.println();
						LinkedSet.printForward();
					    System.out.println();

					//Gives the sum of injuries and deaths for the year the user selects
					} else if (manipulationLoop.equalsIgnoreCase("sum")) {
						System.out.print("Enter Summary Year: ");
						String summaryYear = Scan.nextLine();
						Iterator<T> itr = LinkedSet.iterator();
						while(itr.hasNext()) {
							T element = itr.next();
							if (element.toString().contains(summaryYear)) {
							}
						}
						System.out.println("Year: " + summaryYear);

					//Searches the Linked Set for all elements that contain the users input
					} else if (manipulationLoop.equalsIgnoreCase("f")) {
						System.out.print("Enter The Exact Data You Would Like To Find: ");
						String data = Scan.nextLine();
						Iterator<T> itr = LinkedSet.iterator();
						int t = 0;
					      while(itr.hasNext()) {
					         T element = itr.next();
					         if (element.toString().contains(data)) {
					        	 System.out.println(element);
					        	 t++;
					         }
						}
					    System.out.println();
					    System.out.println(data + " Records Found: " + t);
						
					//deletes all elements in the linked set that match the id of the users input
					} else if (manipulationLoop.equalsIgnoreCase("d")) {
						System.out.print("Enter the event id you would like to delete: ");
						T deleteID = (T) Scan.nextLine();
						LinkedSet.remove(deleteID);
						Iterator<T> itr = LinkedSet.iterator();
					      while(itr.hasNext()) {
					         T element = itr.next();
					         if (element.toString().contains((CharSequence) deleteID)) {
					        	 System.out.println(element);
					         }
					      }
					      System.out.print("Would you like to delete all above entries? Enter C to confrim:");
					      String confirmation = Scan.next();
					      if (confirmation.equalsIgnoreCase("C")) {
					    	  LinkedSet.remove(deleteID);
					    	  System.out.println("Items have been removed");
					      }
					
					//sorts the linked set for all option 1-10 by using bubble sort
					} else if (manipulationLoop.equalsIgnoreCase("s")) {
						System.out.print("Enter sorting option 1-10: ");
						String sortOption = Scan.nextLine();
						if (Integer.parseInt(sortOption) <= 10 && Integer.parseInt(sortOption) >= 1) {
							switch (sortOption) {
							case "1":
								LinkedSet.bubbleSort(LinkedSet,1);
								System.out.println("List sorted for 1: ");
								LinkedSet.printBackward();
								break;
							case "2":
								LinkedSet.bubbleSort(LinkedSet,2);
								System.out.println("List sorted for 2: ");
								LinkedSet.printBackward();
								break;
							case "3":
								LinkedSet.bubbleSort(LinkedSet,3);
								System.out.println("List sorted for 3: ");
								LinkedSet.printBackward();
								break;
							case "4":
								LinkedSet.bubbleSort(LinkedSet,4);
								System.out.println("List sorted for 4: ");
								LinkedSet.printBackward();
								break;
							case "5":
								LinkedSet.bubbleSort(LinkedSet,5);
								System.out.println("List sorted for 5: ");
								LinkedSet.printBackward();
								break;
							case "6":
								LinkedSet.bubbleSort(LinkedSet,6);
								System.out.println("List sorted for 6: ");
								LinkedSet.printBackward();
								break;
							case "7":
								LinkedSet.bubbleSort(LinkedSet,7);
								System.out.println("List sorted for 7: ");
								LinkedSet.printBackward();
								break;
							case "8":
								LinkedSet.bubbleSort(LinkedSet,8);
								System.out.println("List sorted for 8: ");
								LinkedSet.printBackward();
								break;
							case "9":
								LinkedSet.bubbleSort(LinkedSet,9);
								System.out.println("List sorted for 9: ");
								LinkedSet.printBackward();
								break;
							case "10":
								LinkedSet.bubbleSort(LinkedSet,10);
								System.out.println("List sorted for 10: ");
								LinkedSet.printBackward();
								break;
							}
						} else {
							System.out.println("Invalid input");
						}
						
					//exits the loop
					} else if (manipulationLoop.equalsIgnoreCase("q")) {
						System.out.println("Thanks for using storm");
						
					}
				}
			}
			else { 
				System.out.println("File is not available");
			}
		}
	}
}
