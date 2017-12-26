package com.cubrid.common.ui.query.action;

import org.eclipse.jface.action.Action;

import com.cubrid.common.ui.CommonUIPlugin;
import com.cubrid.common.ui.query.Messages;
import com.cubrid.common.ui.query.control.QueryExecuter;
import com.cubrid.common.ui.query.control.QueryInfo;
import com.cubrid.common.ui.spi.util.CommonUITool;

public class PrevAction extends Action {
	private final QueryExecuter executer;

	public PrevAction(QueryExecuter result) {
		super(Messages.qedit_nextpage);
		setId("NextAction");
		setImageDescriptor(CommonUIPlugin.getImageDescriptor("icons/queryeditor/query_page_previous.png"));
		setDisabledImageDescriptor(CommonUIPlugin.getImageDescriptor("icons/queryeditor/query_page_previous_disabled.png"));
		setToolTipText(Messages.qedit_nextpage);
		this.executer = result;
	}

	@Override
	public void run() {
		if (executer.isModifiedResult()) {
			CommonUITool.openErrorBox(Messages.errModifiedNotMoving);
			return;
		}

		if (executer.tblResult != null) {
			executer.tblResult.forceFocus();
		}

		QueryInfo queryInfo = executer.getQueryInfo();
		queryInfo.setCurrentPage(queryInfo.getCurrentPage() > 1 ? queryInfo.getCurrentPage() - 1 : 1);
		// TODO Add: read the previous records from file
		executer.makePrevItem();	// makePrevItem();
		executer.updateActions();
	}
}
