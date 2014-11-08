package j2seExample300.Chapter12IO;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
/*
 * �����ṹ��ʾ�ļ�·��
 */
public class FilesTree extends JFrame{
	private JPanel contentPane;
	private JTree tree;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				FilesTree ft = new FilesTree();
				ft.setVisible(true);
			}
		});
	}

	public FilesTree()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("�����ṹ��ʾ�ļ�·��");
		this.setBounds(400, 300, 400, 300);	
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		this.setContentPane(contentPane);
		
		JScrollPane sp = new JScrollPane();
		contentPane.add(sp,BorderLayout.CENTER);
		
		File[] disks = File.listRoots();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		for(File disk:disks){
			root.add(new DefaultMutableTreeNode(disk));
		}
		
		tree = new JTree(root);
		tree.addTreeSelectionListener(new TreeSelectionListener(){
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				do_tree_valueChanged(e);
			}
		});
		sp.setViewportView(tree);
	}
	
	public void do_tree_valueChanged(TreeSelectionEvent e){
		// ����û�ѡ��Ľڵ�
		DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		File selectFile = (File) selectNode.getUserObject();// ��ýڵ�����File���Ͷ���
		if(selectFile.isDirectory()){
			File[] files = selectFile.listFiles(new FileFilter(){

				@Override
				public boolean accept(File pathname) {
					if(pathname.isHidden()){
						return false;
					}else{
						return true;
					}					
				}
			});
			for(File file:files){
				selectNode.add(new DefaultMutableTreeNode(file));
			}
		}else{
			return;
		}
	}
}
