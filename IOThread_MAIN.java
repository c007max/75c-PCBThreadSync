import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class IOThread_MAIN
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException
	{
		PCB_LL QReady	= new PCB_LL()	;
		PCB_LL QWait	= new PCB_LL()	;
		
		int nodes_T	= 10 ;
		PCB	pcbRunning	= null ;
		Random r1	= new Random();
				
		for (int ii=0; ii<nodes_T; ii++)
		{
			PCB pcbMain	= new PCB();
			QReady.addFirst(pcbMain)	;
			
			System.out.printf("\t%d: %s\n"	,ii	,pcbMain.showPCB());
		}

		for (int ii=0; ii<QReady.size(); ii++)
			System.out.printf("%s\n"	,QReady.get(ii).showPCB()) ;

		IOProcess iop1	= new IOProcess	(QWait)	;
		iop1.start()	;

		while	(!QReady.isEmpty())
		{
			pcbRunning	= QReady.removeFirst()	;
			
			if (r1.nextGaussian()>0.674)
			{
				QWait.addFirst(pcbRunning)	;
			}
		}
		
		iop1.join()	;

//		Thread iop	= new Thread(new IOProcess
//			(pcbRunning
//			,pcb_LL
//			));
//
//		iop.start();				
////	0100
//		System.out.printf("***\tmain-0100: thread started %s %d %s\t***\n"
//				,iop.getName()
//				,iop.getId()
//				,iop.getState()
//				);		
//		
//		while (!QReady.isEmpty() || (Thread.activeCount()>1))
//		{
//			pcbRunning	= QReady.removeFirst() ;
//			
//			for
//			
//			pcbRunning.add_CPU_used(r1.nextInt(5)+6);
//			
//			if (pcbRunning.get_CPU_left() <= 0)
//			{
//				System.out.printf("***\tmain-0050: (%d) process completed\t used: %d \t max: %d\t***\n"
//						,pcbRunning.get_ID()
//						,pcbRunning.get_CPU_max()
//						,pcbRunning.get_CPU_used()
//						);
//				continue ;				
//			}
//		
//			if (event.get_CPU_event()==2)
//			{
//				Thread iop	= new Thread(new IOProcess
//						(pcbRunning
//						,QReady
//						));
//
//				iop.start();				
//				//	0100
//				System.out.printf("***\tmain-0100: thread started %s %d %s\t***\n"
//						,iop.getName()
//						,iop.getId()
//						,iop.getState()
//						);		
//			}
//			else
//				QReady.addLast(pcbRunning);
//		}
//		
//		for (int ii=0; ii<QReady.size(); ii++)
//			System.out.printf("%s\n"	,QReady.get(ii).showPCB()) ;
//		
		System.out.printf("@@@\tdone\t@@@\n");
	}
}
