import PropTypes from "prop-types";
import { format } from 'date-fns'

function ItemVenda(props){

    const formatCurrency = (value) => {
        const formattedValue = Math.abs(value).toFixed(2).replace('.', ',');
        return value < 0 ? `- R$${formattedValue}` : `R$${formattedValue}`;
    }

    return (
        <tr>
            <td>{props.id_venda}</td>
            <td>{formatCurrency(props.valor)}</td>
            <td>{format(props.data_de_venda, 'dd/MM/yyyy')}</td>
        </tr>
    )
}

ItemVenda.propTypes = {
    id_venda: PropTypes.number.isRequired,
    valor: PropTypes.number.isRequired,
    data_de_venda: PropTypes.any.isRequired,
    flag: PropTypes.number.isRequired
}

export default ItemVenda;