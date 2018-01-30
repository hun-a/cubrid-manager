package com.cubrid.common.ui.query.action;

import org.eclipse.jface.action.Action;

import com.cubrid.common.ui.CommonUIPlugin;
import com.cubrid.common.ui.query.Messages;
import com.cubrid.common.ui.query.control.QueryExecuter;
import com.cubrid.common.ui.spi.util.CommonUITool;

/**
 * 
 * first page action in query editor result
 * 
 * @author seunghun
 * 
 */
public class FirstAction extends
		Action {
	private final QueryExecuter executer;

	/**
	 * The constructor
	 * 
	 * @param result
	 */
	public FirstAction(QueryExecuter result) {
		super(Messages.qedit_lastpage);
		setId("FirstAction");
		setImageDescriptor(CommonUIPlugin.getImageDescriptor("icons/queryeditor/query_page_first.png"));
		setDisabledImageDescriptor(CommonUIPlugin.getImageDescriptor("icons/queryeditor/query_page_first_disabled.png"));
		setToolTipText(Messages.qedit_lastpage);
		this.executer = result;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		if (executer.isModifiedResult()) {
			CommonUITool.openErrorBox(Messages.errModifiedNotMoving);
			return;
		}

		if (executer.tblResult != null) {
			executer.tblResult.forceFocus();
		}

		executer.makeFirstItem();
		executer.updateActions();
	}
}
