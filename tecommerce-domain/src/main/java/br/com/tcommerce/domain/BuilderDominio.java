package br.com.tcommerce.domain;

import java.io.Serializable;

public abstract class BuilderDominio<TRoot extends BaseEntity> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected abstract TRoot getDominio();

	public final TRoot instance() {
		TRoot tRoot = getDominio();
		tRoot.isValid();

		return tRoot;
	}

}
