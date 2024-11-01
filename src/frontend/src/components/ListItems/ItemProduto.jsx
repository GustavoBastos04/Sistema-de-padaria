import PropTypes from "prop-types";

function ItemProduto(props){
    return (
        <tr>
            <td>{props.nome}</td>
            <td>{props.valor}</td>
            <td>{props.quantidade}</td>
            <td className="text-end">
                {props.action1}
                {props.action2}
                {props.action3}
            </td>
        </tr>
    )
}

ItemProduto.propTypes = {
    nome: PropTypes.string.isRequired,
    valor: PropTypes.string.isRequired,
    quantidade: PropTypes.string.isRequired,
    action1: PropTypes.element.isRequired,
    action2: PropTypes.element.isRequired,
    action3: PropTypes.element.isRequired,
}

export default ItemProduto;