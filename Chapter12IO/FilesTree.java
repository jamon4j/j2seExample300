package j2seExample300.Chapter12IO;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
/*
 * 以树结构显示文件路径
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
		this.setTitle("以树结构显示文件路径");
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
		// 获得用户选择的节点
		DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		File selectFile = (File) selectNode.getUserObject();// 获得节点代表的File类型对象
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
