///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Program 3
// Files:            Platform.java, Train.java, SimpleStack.java,
//					 SimpleQueue.java, EmptyPlatformException.java,
//					 Station.java, StackADT.java, QueueADT.java, 
//					 PlatformADT.java, FullStackException.java, 
//					 FullQueueException.java, FullPlatformException.java
//					 EmptyStackException.java, EmptyQueueException.java
// Semester:         CS367 Fall 2014
//
// Author:           Brett Percy
// Email:            bpercy@wisc.edu
// CS Login:         percy
// Lecturer's Name:  Jim Skrentny
// Lab Section:      -
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If allowed, learn what PAIR-PROGRAMMING IS, 
//                   choose a partner wisely, and complete this section.
//
// Pair Partner:     Sheng-Hua Lin
// Email:            slin96@wisc.edu
// CS Login:         Sheng-hu
// Lecturer's Name:  Jim Skrentny
// Lab Section:      -
//
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          (list anyone who helped you write your program)
//////////////////////////// 80 columns wide //////////////////////////////////



import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Brett
 *
 */
public class TrainSimulator {
	
	
	/**
	 * 
	 * main is where the user can decide whether they want option 0,1, or 2.
	 * the main will print either a list of the actions for each train at
	 * each station, the actual times of departures for each train at each
	 * station, or the actual times of arrivals for each train at each station
	 * 
	 */
	public static void main(String args[]) {

		try {

			int numTrains = 0; // stores the number of trains
			int numStations = 0; // stores the number of stations

			// boolean to checking if args[] is valid
			boolean goodArgument = true;
			// arraylist of trains
			ArrayList<Train> trains = new ArrayList<Train>();
			// arraylist of stations
			ArrayList<Station> stations = new ArrayList<Station>();
			// n denotes the information to output to the console
			int n = Integer.parseInt(args[0]);
			
			//checks to see if n is a valid input
			if (!((n == 0) || (n == 1) || (n == 2))) {
				goodArgument = false;
			}

			//if good arg[] is passed, read in the file
			if (goodArgument) {
				File stationsFile = new File(args[1]);
				File trainsFile = new File(args[2]);
				Scanner stationsFileReader = new Scanner(stationsFile);
				Scanner trainsFileReader = new Scanner(trainsFile);

				numStations = stationsFileReader.nextInt();
				numTrains = trainsFileReader.nextInt();
				stationsFileReader.nextLine();
				trainsFileReader.nextLine();

				while (stationsFileReader.hasNextLine()) {

					String line2[] = stationsFileReader.nextLine().split(",");
					int stationsID = Integer.parseInt(line2[0]);
					int stationsCapacity = Integer.parseInt(line2[1]);

					stations.add(new Station(stationsID, stationsCapacity));

				}
				while (trainsFileReader.hasNextLine()) {
					String line1[] = trainsFileReader.nextLine().split(",");
					Train newTrain = new Train(Integer.parseInt(line1[0]));
					for (int k = 1; k < line1.length; k++) {
						newTrain.getETD().add(Integer.parseInt(line1[k]));
					}
					trains.add(newTrain);
				}
			}
			if (goodArgument) {
				// adds all trains to the first station
				

				//creates a list with size (numStations-1) that each item
				//contains 10 arrays of simpleQueue with size trains
				ArrayList<SimpleQueue[]> allTracks =
						new ArrayList<SimpleQueue[]>();
				for (int k = 0; k < numStations - 1; k++) {
					SimpleQueue[] tracks = new SimpleQueue[10];
					for (int i = 0; i < 10; i++) {
						tracks[i] = new SimpleQueue(numTrains);
					}
					allTracks.add(tracks);
				}
				for (int i = numTrains - 1; i >= 0; i--) {
					try {
						stations.get(0).getPlatform().put(trains.get(i));
						
					} catch (FullPlatformException e) {

					}
				}
				
				int time = 1;
				//the output of when "0" is selected
				ArrayList<String> output = new ArrayList<String>();
				
				//moves trains through tracks and stations until the last
				//station is filled
				while (!stations.get(numStations - 1).getPlatform().isFull()) {
					//an array list to keep track of trains moved, in order to
					//prevent the same train from moving twice during one time
					//interval
					ArrayList<Integer> movedTrainsID = 
							new ArrayList<Integer>();

					
					for (int outerLoop = numStations - 2;
							outerLoop >= 0; outerLoop--) {
							
/////// (1)moves trains from stations to next track
						//checks to see if the item on top can not exit
						boolean stuck = false;
						//keeps looping until the station is empty of its stuck
						while ((!stations.get(outerLoop).getPlatform()
								.isEmpty()) && (!stuck)) {
							try {
								//
								if (stations.get(outerLoop).getPlatform()
									.check().getETD().get(outerLoop) <= time) {
									
									movedTrainsID.add(stations.get(outerLoop)
											.getPlatform().check().getId());
									
									Train temp = stations.get(outerLoop)
											.getPlatform().get();
									
									output.add(time + ":	Train " +
																temp.getId()
											+ " has exited from station "
											+ (outerLoop + 1));
									allTracks.get(outerLoop)[0].enqueue(temp);
									/* change peek to the last added train */
									temp.getATD().add(time);
								} else {
									stuck = true;
								}
							} catch (EmptyPlatformException e) {

							} catch (FullQueueException e) {

							}
						}
/////// (1)

/////// (2)moves the trains from one single part (out of the ten) of a track to
		//the next single part or the next station
						for (int k = 0; k < 10; k++) {
							if (!(allTracks.get(outerLoop)[k].isEmpty())) {
								
					///// (2.1)moves trains to the next stations from tracks
								if (k == 9) {
									//checks to
									boolean full = false;
									boolean notMoved = false;

									while ((!allTracks.get(outerLoop)[9]
											.isEmpty())
											&& (!stations.get(outerLoop + 1)
												.getPlatform().isFull())
											&& !full && !notMoved) {
										try {
											Train temp = ((Train) (allTracks
												.get(outerLoop)[9].peek()));
											if (movedTrainsID.contains(temp
													.getId())) {
												notMoved = true;
											} else {
												stations.get(outerLoop + 1)
												.getPlatform().put((Train)
												((SimpleQueue)(allTracks
												.get(outerLoop)[9]))
												.dequeue());
												temp.getATA().add(time);
												output.add(time + ":	Train "
												+ temp.getId() + " has been"
												+ " parked at station " +
												(outerLoop + 2) + ".");
											}
										} catch (FullPlatformException e) {
											full = true;

										} catch (EmptyQueueException e) {
										}
									}
								}
					///// (2.1)
					///// (2.2)moves trains to the next single part of a track
								else {
									try {
										boolean notMoved = false;
										while ((!allTracks.get(outerLoop)[k]
												.isEmpty()) && !notMoved) {
											if (movedTrainsID
												.contains(((Train) (allTracks
												.get(outerLoop)[k].peek()))
												.getId())) {
												notMoved = true;
											}
											else {
												SimpleQueue temp = allTracks
													.get(outerLoop)[k];
												movedTrainsID.add(((Train) temp
													.peek()).getId());

												allTracks.get(outerLoop)[k + 1]
													.enqueue(allTracks
													.get(outerLoop)[k]
													.dequeue());

											}
										}
									} catch (FullQueueException e) {

									} catch (EmptyQueueException e) {

									}
								}
					///// (2.2)
							}
						}
/////// (2)
					}
					time++;
				}

				if (n == 0) {
					for (int i = 0; i < output.size(); i++) {
						System.out.println(output.get(i));
					}
				}

				if (n == 1) {
					for (int i = 0; i < numTrains; i++) {
						System.out.println(trains.get(i).getATD());
					}
				}

				if (n == 2) {
					for (int i = 0; i < numTrains; i++) {
						System.out.println(trains.get(i).getATA());
					}
				}
			} else {
				System.out.println("Please enter the accepted option (0-2) "
						+ "for console output.");
			}

		} catch (FileNotFoundException e) {
			System.out.println("The file you entered was not found. Please "
					+ "enter a valid path.");
		}

	}

}