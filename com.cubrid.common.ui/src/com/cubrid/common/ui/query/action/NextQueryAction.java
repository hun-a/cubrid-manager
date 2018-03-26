package com.cubrid.common.ui.query.action;

import org.eclipse.jface.action.Action;

import com.cubrid.common.ui.CommonUIPlugin;
import com.cubrid.common.ui.query.Messages;
import com.cubrid.common.ui.query.control.QueryExecuter;

public class NextQueryAction extends Action {
	private final QueryExecuter executer;

	public NextQueryAction(QueryExecuter result) {
		super(Messages.qedit_next_run);
		setId("NextQueryAction");
		setImageDescriptor(CommonUIPlugin.getImageDescriptor("icons/queryeditor/next_query_run.png"));
		setDisabledImageDescriptor(CommonUIPlugin.getImageDescriptor("icons/queryeditor/next_query_run_disabled.png"));
		setToolTipText(Messages.qedit_next_run);
		this.executer = result;
	}

	@Override
	public void run() {
	}
}
